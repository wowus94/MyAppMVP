package com.example.myappmvp

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when (id) {
            R.id.btnOne -> { //TODO исправить, должно быть без id
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnTwo -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnThree -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}