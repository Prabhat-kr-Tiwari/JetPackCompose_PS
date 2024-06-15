package com.prabhat.introduction.todo

import com.prabhat.introduction.todo.data.Todo
import com.prabhat.introduction.todo.data.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository
@Inject
constructor(private val dao: TodoDao) {

    suspend fun insert(todo: Todo)= withContext(Dispatchers.IO){
        dao.insert(todo)
    }


    fun getAllTodos():Flow<List<Todo>> =dao.getAllTodos()
}