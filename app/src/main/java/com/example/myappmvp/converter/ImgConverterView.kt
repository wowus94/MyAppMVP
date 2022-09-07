package com.example.myappmvp.converter

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ImgConverterView : ProgressView, ErrorView, MvpView {

    fun showOriginImg(pathImageFile: String)

    fun showConvertImg(pathImageFile: String)

    fun showMessage(text: String)
}