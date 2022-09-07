package com.example.myappmvp.converter

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ConverterScreen : IScreens {

    override fun imageConverter(): Screen =
        FragmentScreen { ImgConverterFragment() }
}