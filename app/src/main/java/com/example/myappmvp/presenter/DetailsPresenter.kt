package com.example.myappmvp.presenter

import com.example.myappmvp.repository.GithubRepository
import com.example.myappmvp.user.details.UserDetailsView
import com.example.myappmvp.utils.disposeBy
import com.example.myappmvp.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class DetailsPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserDetailsView>() {

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        repository.getUserById(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                    viewState.hideLoading()
                },
                {}
            ).disposeBy(bag)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }
}
