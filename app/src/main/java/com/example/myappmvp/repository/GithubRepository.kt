package com.example.myappmvp.repository

import com.example.myappmvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserById(login: String): Single<GithubUser>
    fun getUserRepos(
        login: String,
        type: String?,
        sort: String?,
        direction: String?,
        perPage: Int?,
        page: Int?
    ): Single<GithubUser>

}