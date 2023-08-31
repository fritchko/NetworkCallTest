package com.example.bottomnavtest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TestViewModel: ViewModel() {

    val result = MutableLiveData("")

    fun networkFactCall(){
      viewModelScope.launch(IO) {
          var resultRepository = TestRepository.networkFactCall()
          if (resultRepository?.isSuccessful == true){
              result.postValue(resultRepository.body()?.fact.orEmpty())
          }
      }
    }

}