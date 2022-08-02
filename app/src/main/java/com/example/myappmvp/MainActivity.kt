package com.example.myappmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myappmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnOne.setOnClickListener {
                tvTextOne.text = (++counters[0]).toString()
            }
            btnTwo.setOnClickListener {
                tvTextTwo.text = (++counters[1]).toString()
            }
            btnTree.setOnClickListener {
                tvTextThree.text = (++counters[2]).toString()
            }
        }
    }

    private fun initViews() {
        with(binding) {
            tvTextOne.text = counters[0].toString()
            tvTextTwo.text = counters[1].toString()
            tvTextThree.text = counters[2].toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray("counters")
        counters.let { list ->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }
        initViews()
    }
}