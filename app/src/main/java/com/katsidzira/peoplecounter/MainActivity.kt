package com.katsidzira.peoplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.katsidzira.peoplecounter.controller.CounterController
import com.katsidzira.peoplecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var controller: CounterController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        controller = CounterController
        mainBinding.controller = controller

        mainBinding.buttonAdd.setOnClickListener {
            controller.addPerson()
            updateViews()
        }

        mainBinding.buttonRemove.isInvisible = true
        mainBinding.buttonRemove.setOnClickListener {
            controller.removePerson()
            updateViews()
        }

        mainBinding.buttonReset.setOnClickListener {
            controller.reset()
            if (controller.getPeople() == 0) {
                mainBinding.buttonRemove.isInvisible = true
            } else {
                mainBinding.buttonRemove.isInvisible = true
            }
            updateViews()
        }
    }

    private fun updateViews() {
        if (controller.getPeople()!! > 0) {
            mainBinding.buttonRemove.isVisible = true
        } else {
            mainBinding.buttonRemove.isInvisible = true
        }
        mainBinding.textviewPeople.text = "${controller.getPeople().toString()} people"
        mainBinding.textviewTotal.text = "Total: ${controller.getTotal().toString()}"
    }
}