package com.example.rishabh.coroutineexampleproject

import android.media.tv.StreamEventRequest
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel(private val myDemoRepository: MyDemoRepository) : ViewModel() {

    private val _sendDataToLiveData = MutableLiveData<String>()
    val sendData: LiveData<String> get() = _sendDataToLiveData


    private val _userData = MutableLiveData< String>()
    val userData : LiveData<String> get() = _userData

    /**
     *  use viewModelScope to launch a coroutine. viewModelScope is tied to the
     *  ViewModel's lifecycle and will be automatically canceled when the ViewModel
     *  is cleared.
     */
    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = performNetworkRequest()
            _sendDataToLiveData.postValue(result)
        }
    }

    private suspend fun performNetworkRequest(): String {
        delay(2000)
        return "Fetched Data from Network"
    }


    /*** withContext Example()
     *
     */

    fun getUserData(userId: String) {
        viewModelScope.launch {
            val data = myDemoRepository.fetchUserData()
            _userData.postValue(data)
        }
    }
}