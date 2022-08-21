package com.example.myappmvp.repository.impl

import com.example.myappmvp.mapper.UserMapper
import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.network.UsersApi
import com.example.myappmvp.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi
) : GithubRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }


    override fun getUserById(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }
}
