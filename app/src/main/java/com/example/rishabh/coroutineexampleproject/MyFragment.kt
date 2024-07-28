package com.example.rishabh.coroutineexampleproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyFragment: Fragment(){

    /**
     * This is the Example for the Life Cycle Scope
    lifecycleScope is tied to the lifecycle of a component, such as an Activity or Fragment.
    It's a safer alternative to GlobalScope as it automatically cancels the coroutine when the
    lifecycle is destroyed.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            val result = fetchData()
            // Return Data add Livedata
        }
    }

    private suspend fun fetchData(): String{
        return withContext(Dispatchers.IO){
            fetchDataFromNetwork()
        }
    }

    private suspend fun fetchDataFromNetwork(): String{
        delay(2000)
        return "Fetch data From Network "
    }


}