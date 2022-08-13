package com.example.myappmvp.presenter

import com.example.myappmvp.navigation.UsersScreen
import com.example.myappmvp.userlogin.UserLoginView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserLoginPresenter(
    private val router: Router
) : MvpPresenter<UserLoginView>() {

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}