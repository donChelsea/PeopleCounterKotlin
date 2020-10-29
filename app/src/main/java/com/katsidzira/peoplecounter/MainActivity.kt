package com.katsidzira.peoplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.katsidzira.peoplecounter.controller.CounterController
import com.katsidzira.peoplecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var totalTv: TextView
    private lateinit var peopleTv: TextView
    private lateinit var buttonReset: Button
    private lateinit var buttonAdd: Button
    private lateinit var buttonRemove: Button
    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val controller = CounterController
        mainBinding.controller = controller

        mainBinding.buttonAdd.setOnClickListener {
            controller.addPerson()
            mainBinding.textviewPeople.text = "${controller.getPeople().toString()} people"
        }
    }
}