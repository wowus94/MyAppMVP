package com.example.myappmvp.converter

import android.net.Uri
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ImgConverterView : ProgressView, ErrorView, MvpView {
    fun init()

    fun showOriginImg(uri: Uri)

    fun showConvertImg(uri: Uri)

    fun showMessage(text: String)

    fun btnStartConvertEnable()

    fun btnStartConvertDisabled()

    fun btnCancelConvertEnabled()

    fun btnCancelConvertDisabled()

    fun signCancelConvertShow()

    fun signCancelConvertHide()

    fun signGetStartedShow()

    fun signGetStartedHide()

    fun signWaitingShow()

    fun signWaitingHide()

}