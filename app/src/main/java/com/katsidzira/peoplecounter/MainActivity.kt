package com.katsidzira.peoplecounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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
        updateButtonVisibility()
        updateTextColor()

        val currentTotal = controller.getTotal().toString()
        val currentPeople = controller.getPeople().toString()
        binding.textviewPeople.text = "$currentPeople people"
        binding.textviewTotal.text = "Total: $currentTotal"
    }

    private fun updateTextColor() {
        if (controller.getPeople()!! >= 15) {
            binding.textviewPeople.setTextColor(Color.RED)
        } else {
            binding.textviewPeople.setTextColor(Color.BLACK)
        }
    }

    private fun updateButtonVisibility() {
        if (controller.getPeople()!! > 0) {
            binding.buttonRemove.isVisible = true
        } else {
            binding.buttonRemove.isInvisible = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val currentTotal = controller.getTotal().toString()
        val currentPeople = controller.getPeople().toString()
        outState.putString("total", currentTotal)
        outState.putString("people", currentPeople)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val currentTotal = savedInstanceState.getString("total")
        val currentPeople = savedInstanceState.getString("people")
        binding.textviewPeople.text = "$currentPeople people"
        binding.textviewTotal.text = "Total: $currentTotal"

        updateButtonVisibility()
        updateTextColor()
    }
}