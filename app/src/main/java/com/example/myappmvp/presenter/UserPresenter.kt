package com.example.myappmvp.presenter

import com.example.myappmvp.converter.ConverterScreen
import com.example.myappmvp.navigation.UserDetailsScreen
import com.example.myappmvp.repository.GithubRepository
import com.example.myappmvp.user.UserView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProgressBar()
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideProgressBar()
                },
                {

                }
            )
    }

    fun openUserDetailsFragment(login: String) {
        router.navigateTo(UserDetailsScreen(login))
    }

    fun imgConverter() {
        router.navigateTo(ConverterScreen().imageConverter())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}