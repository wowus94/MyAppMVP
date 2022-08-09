package com.example.myappmvp

import moxy.MvpPresenter


class CountersPresenter(private val model: CountersModel) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onCounterOneClick(id: Int) {
        val newValue = model.next(0)
        viewState.setCounterOneText(newValue.toString())
    }

    fun onCounterTwoClick(id: Int) {
        val newValue = model.next(1)
        viewState.setCounterTwoText(newValue.toString())
    }

    fun onCounterThirdClick(id: Int) {
        val newValue = model.next(2)
        viewState.setCounterThird(newValue.toString())
    }
}