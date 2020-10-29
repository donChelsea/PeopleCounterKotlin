package com.katsidzira.peoplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.katsidzira.peoplecounter.controller.GameController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("main activity", "counter=${GameController.getPeople()}")
    }
}