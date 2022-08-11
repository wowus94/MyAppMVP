package com.example.myappmvp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappmvp.databinding.ActivityMainBinding
import com.example.myappmvp.main.UserAdapter
import com.example.myappmvp.model.GithubUser
import com.example.myappmvp.repository.impl.CountersRepository
import com.example.myappmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UserAdapter()

    val presenter by moxyPresenter { CountersPresenter(GithubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerViewGithubUser.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewGithubUser.setItemViewCacheSize(2)
            recyclerViewGithubUser.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

}