package com.example.myappmvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubUser(
    val id: Long,
    val login: String,
    val avatarUrl: String?,
    val reposUrl: String

) : Parcelable