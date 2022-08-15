package com.example.myappmvp.repository.impl

import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Vladimir"),
        GithubUser("Nikolay"),
        GithubUser("Oleg"),
        GithubUser("Svetlana"),
        GithubUser("Anna"),
        GithubUser("Anton"),
        GithubUser("Tatyana")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single
            .create<List<GithubUser>> {
                it.onSuccess(repositories)
            }
    }
}