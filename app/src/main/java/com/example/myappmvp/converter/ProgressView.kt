package com.example.myappmvp.converter

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProgressView {

    fun showProgressBar()

    fun hideProgressBar()
}