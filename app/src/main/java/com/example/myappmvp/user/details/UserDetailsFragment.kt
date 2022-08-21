package com.example.myappmvp.user.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappmvp.MyApplication
import com.example.myappmvp.databinding.FragmentDetailsBinding
import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.network.NetworkProvider
import com.example.myappmvp.presenter.DetailsPresenter
import com.example.myappmvp.repository.impl.GithubRepositoryImpl
import com.example.myappmvp.user.details.UserDetailsFragment.Companion.ARG_LOGIN
import com.example.myappmvp.utils.OnBackPressedListener
import com.example.myappmvp.utils.loadImage
import com.example.myappmvp.utils.makeGone
import com.example.myappmvp.utils.makeVisible
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, OnBackPressedListener {

    companion object{
        private const val ARG_LOGIN = "ARG_LOGIN"

        fun getInstance(login: String): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments =Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }
        }
    }

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter(
            GithubRepositoryImpl(NetworkProvider.usersApi),
            MyApplication.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDetailsBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.loadUser(it)
        }
    }


    private var viewBinding: FragmentDetailsBinding? = null

    override fun show(user: GithubUser) {
        viewBinding?.apply {
            tvUserLogin.text = user.login
            ivUserAvatar.loadImage(user.avatarUrl)
        }
    }

    override fun showLoading() {
        viewBinding?.apply {
            tvUserLogin.makeGone()
            ivUserAvatar.makeGone()
            progress.makeVisible()
        }
    }

    override fun hideLoading() {
        viewBinding?.apply {
            tvUserLogin.makeVisible()
            ivUserAvatar.makeVisible()
            progress.makeGone()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    override fun onBackPressed() = presenter.onBackPressed()
}