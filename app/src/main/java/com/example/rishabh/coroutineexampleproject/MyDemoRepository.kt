package com.example.rishabh.coroutineexampleproject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MyDemoRepository {

    /***
    The fetchUserData() uses withContext(Dispatchers.IO) to switch to the IO
    dispatcher for performing a potentially long-running operation like fetching data
    from a database or network.
    This ensures that the main thread is not blocked during the operation.
     */

    suspend fun fetchUserData(): String{
        return withContext(Dispatchers.IO){
            simulateNetworkRequest()
        }

    }

    private suspend fun simulateNetworkRequest(): String {
        // Simulate delay for network request
       delay(2000)
        return "Data from network"
    }
}