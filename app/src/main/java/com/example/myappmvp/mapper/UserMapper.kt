package com.example.myappmvp.mapper

import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.network.UserDto

object UserMapper {

    fun mapToEntity(dto: UserDto): GithubUser {
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
}