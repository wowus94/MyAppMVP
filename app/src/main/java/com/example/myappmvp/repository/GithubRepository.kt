package com.example.myappmvp.repository

import com.example.myappmvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}