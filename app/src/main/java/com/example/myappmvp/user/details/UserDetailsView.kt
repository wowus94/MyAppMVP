package com.example.myappmvp.user.details

import com.example.myappmvp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {

    fun show(user: GithubUser)
    fun showLoading()
    fun hideLoading()

}