package com.example.myappmvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubUser(
    val login: String
) : Parcelable