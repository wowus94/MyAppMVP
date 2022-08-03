package com.example.myappmvp

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when (id) {
            btn_one -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            btn_two -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            btn_three -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}