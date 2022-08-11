package com.example.myappmvp.repository.impl

import com.example.myappmvp.repository.GithubRepository
import com.example.myappmvp.model.GithubUser

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

   override fun getUsers(): List<GithubUser> {
        return repositories
    }
}