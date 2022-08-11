package com.example.myappmvp

import com.example.myappmvp.repository.GithubRepository
import moxy.MvpPresenter


class CountersPresenter(private val repository: GithubRepository) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }
}