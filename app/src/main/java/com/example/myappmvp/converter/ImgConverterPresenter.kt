package com.example.myappmvp.converter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ImgConverterPresenter(
    val router: Router
) : MvpPresenter<ImgConverterView>() {
    val disposable = CompositeDisposable()
    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.clear()
    }
}