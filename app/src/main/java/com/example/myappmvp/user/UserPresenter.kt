package com.example.myappmvp.user

import com.example.myappmvp.repository.GithubRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}