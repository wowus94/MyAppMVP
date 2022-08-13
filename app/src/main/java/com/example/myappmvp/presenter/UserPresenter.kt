package com.example.myappmvp.presenter

import com.example.myappmvp.navigation.UserLoginScreen
import com.example.myappmvp.repository.GithubRepository
import com.example.myappmvp.user.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun openUserDetailsFragment(login: String) {
        router.navigateTo(UserLoginScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}