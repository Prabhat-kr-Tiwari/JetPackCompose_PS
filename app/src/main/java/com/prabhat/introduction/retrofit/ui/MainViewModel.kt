package com.prabhat.introduction.retrofit.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prabhat.introduction.retrofit.MainRepository
import com.prabhat.introduction.retrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {


    val response:MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {

        getPost()
    }
    private fun getPost()=viewModelScope.launch {

        Log.d("PRABHAT", "getPost: ${response.value}")
        mainRepository.getPost()
            .onStart {

                response.value=ApiState.Loading
            }
            .catch {it->
                response.value=ApiState.Failure(it)


            }
            .collect {

                response.value=ApiState.Success(it)
            }
    }
}