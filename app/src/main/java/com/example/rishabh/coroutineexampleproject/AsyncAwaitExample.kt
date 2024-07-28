package com.example.rishabh.coroutineexampleproject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class AsyncAwaitExample {
    private fun startAsyncAwaitTask(){
        /**
            runBlocking block is use to de the synchronous jobs in coroutines
            async is used to launch two concurrent coroutines for fetchResult1 and fetchResult2.
            The await function is used to wait for the results. This approach is helpful
            when tasks are independent and can be executed in parallel, reducing the overall execution time.

            async/await: Used for concurrent tasks that return results. async starts the task,
            and await waits for the result.
         */
        runBlocking {
            val fetchResult1= async { fetchData1() }
            val fetchResult2 = async { fetchData2() }

            val result1 = fetchResult1.await()
            val result2 = fetchResult2.await()

            // Send the results from Live data to the VM.
        }
    }

    private suspend fun fetchData1(): String {
        return withContext(Dispatchers.IO) {
            delay(1000)
            "Data1 from async"
        }
    }

    private suspend fun fetchData2(): String {
        return withContext(Dispatchers.IO) {
            delay(2000)
            "Data2 from async"
        }
    }
}