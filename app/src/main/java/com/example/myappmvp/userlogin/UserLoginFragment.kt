package com.example.myappmvp.userlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappmvp.MyApplication
import com.example.myappmvp.databinding.FragmentUserLoginBinding
import com.example.myappmvp.presenter.UserLoginPresenter
import com.example.myappmvp.utils.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

const val USER_LOGIN_EXTRA = "USER_LOGIN_EXTRA"

class UserLoginFragment : MvpAppCompatFragment(), UserLoginView, OnBackPressedListener {

    private var _binding: FragmentUserLoginBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserLoginPresenter(MyApplication.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(USER_LOGIN_EXTRA)?.let {
            binding.userLogin.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun getInstance(login: String): UserLoginFragment {
            val fragment = UserLoginFragment()
            val bundle = Bundle().apply {
                putString(USER_LOGIN_EXTRA, login)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()
}