package com.example.myappmvp

import android.os.Bundle
import com.example.myappmvp.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onCounterOneClick(btn_one)
            }
            btnTwo.setOnClickListener {
                presenter.onCounterTwoClick(btn_two)
            }
            btnThree.setOnClickListener {
                presenter.onCounterThirdClick(btn_three)
            }
        }
    }


    override fun setCounterOneText(counter: String) = with(binding) {
        tvTextOne.text = counter
    }

    override fun setCounterTwoText(counter: String) = with(binding) {
        tvTextTwo.text = counter
    }

    override fun setCounterThird(counter: String) = with(binding) {
        tvTextThree.text = counter
    }
}