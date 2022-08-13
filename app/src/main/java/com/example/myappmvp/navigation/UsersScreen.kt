package com.example.myappmvp.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myappmvp.user.UserFragment
import com.example.myappmvp.userlogin.UserLoginFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

data class UserLoginScreen(val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserLoginFragment.getInstance(login)
    }
}


