package com.example.myappmvp.converter

import android.net.Uri
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class ImgConverterPresenter(
    private val converter: ConverterJpgToPng,
    private val schedulers: IMySchedulers,
    val router: Router
) : MvpPresenter<ImgConverterView>() {
    var disposables = CompositeDisposable()

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }


    override fun onDestroy() {
        disposables.clear()
    }

    fun startConvertingPressed(imageUri: Uri) {
        viewState.showProgressBar()
        viewState.signWaitingShow()
        viewState.signGetStartedHide()
        viewState.btnCancelConvertEnabled()
        converter
            .convert(imageUri)
            .subscribeOn(schedulers.computation())
            .observeOn(schedulers.main())
            .subscribe(object : SingleObserver<Uri> {
                override fun onSubscribe(d: Disposable?) {
                    disposables.add(d)
                }

                override fun onSuccess(t: Uri) {
                    if (t != null) {
                        onConvertingSuccess(t)
                    }
                }

                override fun onError(e: Throwable?) {
                    onConvertingError(e)
                }
            })
    }

    private fun onConvertingSuccess(uri: Uri) {
        viewState.hideProgressBar()
        viewState.btnCancelConvertDisabled()
        viewState.signCancelConvertHide()
        viewState.signWaitingHide()
    }

    private fun onConvertingError(e: Throwable?) {
        viewState.showErrorBar()
        viewState.hideProgressBar()
        viewState.btnCancelConvertDisabled()
        viewState.signWaitingHide()
    }

    fun cancelConvertImagePressed() {
        schedulers.shutdown()
        viewState.hideProgressBar()
        viewState.signWaitingHide()
        viewState.btnCancelConvertDisabled()
        viewState.signCancelConvertShow()
        schedulers.start()
    }


    fun originalImageSelected(imageUri: Uri) {
        viewState.showOriginImg(imageUri)
        viewState.btnStartConvertEnable()
        viewState.signCancelConvertHide()
        viewState.signGetStartedHide()
        viewState.hideErrorBar()
        viewState.signWaitingShow()
    }
}


