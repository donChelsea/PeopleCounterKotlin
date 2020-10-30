package com.katsidzira.peoplecounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.katsidzira.peoplecounter.controller.CounterController
import com.katsidzira.peoplecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: CounterController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        controller = CounterController
        binding.controller = controller

        binding.buttonAdd.setOnClickListener {
            controller.addPerson()
            updateViews()
        }

        binding.buttonRemove.isInvisible = true
        binding.buttonRemove.setOnClickListener {
            controller.removePerson()
            updateViews()
        }

        binding.buttonReset.setOnClickListener {
            controller.reset()
            updateViews()
        }
    }

    private fun updateViews() {
        if (controller.getPeople()!! > 0) {
            binding.buttonRemove.isVisible = true
        } else {
            binding.buttonRemove.isInvisible = true
        }
        if (controller.getPeople()!! >= 15) {
            binding.textviewPeople.setTextColor(Color.RED)
        } else {
            binding.textviewPeople.setTextColor(Color.BLACK)
        }
        binding.textviewPeople.text = "${controller.getPeople().toString()} people"
        binding.textviewTotal.text = "Total: ${controller.getTotal().toString()}"
    }
}