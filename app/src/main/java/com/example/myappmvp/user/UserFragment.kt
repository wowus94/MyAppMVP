package com.example.myappmvp.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappmvp.MyApplication
import com.example.myappmvp.databinding.FragmentUserListBinding
import com.example.myappmvp.main.UserAdapter
import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.presenter.UserPresenter
import com.example.myappmvp.repository.impl.GithubRepositoryImpl
import com.example.myappmvp.userlist.OnItemClickListener
import com.example.myappmvp.utils.OnBackPressedListener
import com.example.myappmvp.utils.hide
import com.example.myappmvp.utils.show
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    private val adapter = UserAdapter(object : OnItemClickListener {
        override fun onItemClick(login: String) {
            presenter.openUserDetailsFragment(login)
        }
    })


    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), MyApplication.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            recyclerViewGithubUser.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewGithubUser.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showProgressBar() {
        viewBinding.progressBar.show()
    }

    override fun hideProgressBar() {
        viewBinding.progressBar.hide()
    }

    override fun onBackPressed() = presenter.onBackPressed()

}