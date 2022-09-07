package com.example.myappmvp.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappmvp.MyApplication
import com.example.myappmvp.R
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ImgConverterFragment : MvpAppCompatFragment(), ImgConverterView {
    val presenter: ImgConverterPresenter by moxyPresenter {
        ImgConverterPresenter(MyApplication.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_img_converter, container, false)
    }

    fun backPressed(): Boolean = presenter.backPressed()

    override fun showOriginImg(pathImageFile: String) {
        TODO("Not yet implemented")
    }

    override fun showConvertImg(pathImageFile: String) {
        TODO("Not yet implemented")
    }

    override fun showMessage(text: String) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar() {
        TODO("Not yet implemented")
    }

    override fun hideProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showErrorBar() {
        TODO("Not yet implemented")
    }

    override fun hideErrorBar() {
        TODO("Not yet implemented")
    }
}