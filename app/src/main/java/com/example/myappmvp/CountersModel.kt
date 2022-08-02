package com.example.myappmvp

class CountersModel {

    private val counters = mutableListOf(1, 1, 1)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int {
        val newResult = counters[position]++
        return newResult
    }

    fun set(position: Int, value: Int) {
        counters[position] = value
    }
}