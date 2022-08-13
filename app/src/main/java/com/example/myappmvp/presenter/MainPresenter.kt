package com.example.myappmvp.presenter

import com.example.myappmvp.main.MainView
import com.example.myappmvp.navigation.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}