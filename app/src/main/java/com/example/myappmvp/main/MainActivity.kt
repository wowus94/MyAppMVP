package com.example.myappmvp.main

import android.os.Bundle
import com.example.myappmvp.MyApplication
import com.example.myappmvp.R
import com.example.myappmvp.databinding.ActivityMainBinding
import com.example.myappmvp.presenter.MainPresenter
import com.example.myappmvp.utils.OnBackPressedListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.containerMain)
    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(MyApplication.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApplication.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        MyApplication.instance.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is
                        OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }
}