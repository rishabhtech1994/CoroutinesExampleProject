package com.example.rishabh.coroutineexampleproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class ActivityExample: AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewModel.sendData.observe(this, Observer { data ->
            findViewById<TextView>(R.id.textView).text = data
        })

        // Trigger data fetch
        viewModel.fetchData()
    }




}