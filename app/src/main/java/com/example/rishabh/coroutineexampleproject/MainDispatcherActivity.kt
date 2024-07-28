package com.example.rishabh.coroutineexampleproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainDispatcherActivity: AppCompatActivity(){

    private val mainScope = MainScope()

    /**
    Dispatchers.Main is confined to the main UI thread and is used for updating UI components.
    It's essential for tasks that need to interact with the UI, such as showing a dialog or updating a TextView.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainScope.launch {
            val result = fetchData()
            withContext(Dispatchers.Main){
                findViewById<TextView>(R.id.textView).text = result
            }
        }


    }

    private suspend fun fetchData(): String {
        // Simulate a network request
        delay(2000)
        return "Data from network"
    }
}