package com.prabhat.introduction.todo.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import com.prabhat.introduction.retrofit.MainRepository
import com.prabhat.introduction.todo.TodoRepository
import com.prabhat.introduction.todo.data.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository):ViewModel() {

    val response:MutableState<List<Todo>> = mutableStateOf(listOf())


    fun insert(todo: Todo)= viewModelScope.launch{

        todoRepository.insert(todo)
    }


    init {

        getAllTodos()
    }
    fun getAllTodos()=viewModelScope.launch {
        todoRepository.getAllTodos().catch {e->
            Log.d("PRABHAT", "getAllTodos: ${e.message}")

        }.collect{

            response.value=it
        }
    }


}