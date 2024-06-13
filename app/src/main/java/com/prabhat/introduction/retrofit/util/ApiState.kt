package com.prabhat.introduction.retrofit.util

import com.prabhat.introduction.retrofit.Post

sealed class ApiState {

    class Success(val data:List<Post>):ApiState()
    class Failure(val msg:Throwable):ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}