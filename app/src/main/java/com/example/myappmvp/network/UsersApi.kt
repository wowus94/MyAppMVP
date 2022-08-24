package com.example.myappmvp.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApi {

    @GET("/users")
    fun getAllUsers(): Single<List<UserDto>>

    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): Single<UserDto>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login: String,
        @Query("type") type: String?,
        @Query("sort") sort: String?,
        @Query("direction") direction: String?,
        @Query("per_page") perPage: Int?,
        @Query("page") page: Int?
    ): Single<UserDto>

}