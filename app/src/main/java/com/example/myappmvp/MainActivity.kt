package com.example.myappmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myappmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onCounterClick(btn_one)
            }
            btnTwo.setOnClickListener {
                presenter.onCounterClick(btn_two)
            }
            btnThree.setOnClickListener {
                presenter.onCounterClick(btn_three)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvTextOne.text = counter
                1 -> tvTextTwo.text = counter
                2 -> tvTextThree.text = counter
            }
        }
    }
}