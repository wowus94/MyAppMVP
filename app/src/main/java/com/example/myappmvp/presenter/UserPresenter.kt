package com.example.myappmvp.presenter

import com.example.myappmvp.navigation.UserLoginScreen
import com.example.myappmvp.repository.GithubRepository
import com.example.myappmvp.user.UserView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

class UserPresenter(private val repository: GithubRepository, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProgressBar()
        repository.getUsers()
            .delay(3000L, TimeUnit.MILLISECONDS)
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
        router.navigateTo(UserLoginScreen(login))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}