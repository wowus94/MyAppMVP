package com.example.myappmvp.converter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappmvp.MyApplication
import com.example.myappmvp.databinding.FragmentImgConverterBinding
import com.example.myappmvp.utils.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ImgConverterFragment : MvpAppCompatFragment(), ImgConverterView, OnBackPressedListener {

    private var _viewBinding: FragmentImgConverterBinding? = null
    private val viewBinding get() = _viewBinding!!
    private var imageUri: Uri? = null
    private val presenter: ImgConverterPresenter by moxyPresenter {
        ImgConverterPresenter(
            ConverterJpgToPng(requireContext()),
            MySchedulersFactory.create(),
            MyApplication.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentImgConverterBinding.inflate(inflater, container, false)
        .also { _viewBinding = it }.root

    override fun init() {
        hideProgressBar()
        hideErrorBar()
        btnStartConvertDisabled()
        btnCancelConvertDisabled()
        signGetStartedShow()
        signCancelConvertHide()
        signWaitingShow()
        viewBinding.btnAddImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/jpg"
            startActivityForResult(intent, 1000)
        }
        viewBinding.btnConvert.setOnClickListener {
            imageUri?.let(presenter::startConvertingPressed)
        }
        viewBinding.btnCancel.setOnClickListener {
            presenter.cancelConvertImagePressed()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Activity.RESULT_OK && requestCode == 1000) {
            imageUri = data?.data
            imageUri?.let { presenter.originalImageSelected(it) }
        }
    }

    override fun showOriginImg(uri: Uri) {
        viewBinding.ivStartImg.setImageURI(uri)
    }

    override fun showConvertImg(uri: Uri) {
        viewBinding.ivConvertPng.setImageURI(uri)
    }

    override fun showMessage(text: String) {
        //TODO("Not yet implemented")
    }

    override fun btnStartConvertEnable() {
        viewBinding.btnConvert.isEnabled = true
    }

    override fun btnStartConvertDisabled() {
        viewBinding.btnConvert.isEnabled = false
    }

    override fun btnCancelConvertEnabled() {
        viewBinding.btnCancel.isEnabled = true
    }

    override fun btnCancelConvertDisabled() {
        viewBinding.btnCancel.isEnabled = false
    }

    override fun signCancelConvertShow() {
        viewBinding.ivCancelConvert.visibility = View.VISIBLE
    }

    override fun signCancelConvertHide() {
        viewBinding.ivCancelConvert.visibility = View.GONE
    }

    override fun signGetStartedShow() {
        viewBinding.ivStartImg.visibility = View.VISIBLE
    }

    override fun signGetStartedHide() {
        viewBinding.ivStartImg.visibility = View.GONE
    }

    override fun signWaitingShow() {
        viewBinding.ivConvertPng.visibility = View.VISIBLE
    }

    override fun signWaitingHide() {
        viewBinding.ivConvertPng.visibility = View.GONE
    }

    override fun showProgressBar() {
        viewBinding.progressBarTwo.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        viewBinding.progressBarTwo.visibility = View.GONE
    }

    override fun showErrorBar() {
        viewBinding.ivStartImg.visibility = View.VISIBLE
    }

    override fun hideErrorBar() {
        viewBinding.ivStartImg.visibility = View.GONE
    }

    override fun onBackPressed() = presenter.backPressed()
}


