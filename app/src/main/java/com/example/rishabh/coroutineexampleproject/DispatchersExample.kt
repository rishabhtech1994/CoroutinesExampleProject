package com.example.rishabh.coroutineexampleproject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

/**
Dispatchers.Default: Use for CPU-intensive tasks.
Dispatchers.IO: Use for I/O-bound tasks.
Dispatchers.Main: Use for UI-related tasks. --> Example in Main Dispatcher Activity
Dispatchers.Unconfined: Use for tasks that don't require a specific thread.
 */

class DispatchersExample {
    /**
    Dispatchers.Default is used for CPU-intensive tasks, such as sorting a large list, image processing,
    or complex computations.
    It is backed by a shared pool of threads and is the default dispatcher for coroutines
    launched with GlobalScope.
     */

    private fun exampleDispatcherDefault(){
        runBlocking {
            val result = withContext(Dispatchers.Default){
                doBigCalculations()
            }
            print("result $result")
        }
    }

    private fun doBigCalculations(): Int{
        return (1..1_000_000).sum()
    }


    /**
    Dispatchers.IO is used for I/O-bound tasks, such as reading from or writing to a database,
    making network requests, or performing file I/O.
    It uses a shared pool of on-demand created threads and is optimized for I/O operations.
     */

    private fun exampleDispatcherIO(){
        runBlocking {
            val result  = withContext(Dispatchers.IO){
                val text = doIOTask("Example.txt")
            }
        }
    }

    private fun doIOTask(fileName: String): String{
         return File(fileName).readText()
    }


    /**
    Dispatchers.Unconfined starts a coroutine in the caller thread but only until the first suspension point.
    After that, the coroutine resumes in whatever thread the suspension point was resumed on.
    It's typically used for coroutines that don't require a specific threading policy.

     */
    fun dispatcherUnConfined(){
        runBlocking {
            println("Main program starts on thread: ${Thread.currentThread().name}")
            withContext(Dispatchers.Unconfined) {
                println("Unconfined dispatcher starts on thread: ${Thread.currentThread().name}")
                delay(1000)
                println("Unconfined dispatcher resumes on thread: ${Thread.currentThread().name}")
            }
        }
        println("Main program ends on thread: ${Thread.currentThread().name}")
    }


}