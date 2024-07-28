package com.example.rishabh.coroutineexampleproject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GlobalScopeExample {

    private fun getGlobalScope(){
        /**
        GlobalScope is a global coroutine scope that is not tied to any lifecycle.
        It's typically discouraged in Android applications because it doesn't get canceled
        with the lifecycle of components like Activities or Fragments, potentially leading to memory leaks.
         */

        GlobalScope.launch(Dispatchers.IO) {
            val result = fetchData()
            // Send result to VM back
        }
    }

    private suspend fun fetchData(): String {
        // Simulate network delay
        delay(2000)
        return "Data from GlobalScope"
    }
}