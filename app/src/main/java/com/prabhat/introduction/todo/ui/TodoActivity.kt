package com.prabhat.introduction.todo.ui

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.prabhat.introduction.todo.data.Todo
import com.prabhat.introduction.ui.theme.IntroductionTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TodoActivity : ComponentActivity() {


    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    AddToolBar()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddToolBar() {
        Scaffold(topBar = {

            TopAppBar(title = { Text(text = "Todo App") },

                colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
            )
        }, floatingActionButton = {
            val openDialog = remember {
                mutableStateOf(false)
            }
            FloatingActionButton(
                onClick = {
                    openDialog.value = true


                },
            ) {

                    AddDialogBox(openDialog = openDialog)

                    Icon(imageVector = Icons.Default.Add, contentDescription = "")


            }
        }


        ) { it ->
            it
            Column(modifier = Modifier.padding(top = 66.dp)) {

                Recyclerview(todoViewModel = todoViewModel)
            }

        }
    }


    @Composable
    fun AddDialogBox(openDialog: MutableState<Boolean>) {

        val title = remember {
            mutableStateOf("")
        }
        val description = remember {
            mutableStateOf("")
        }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                confirmButton = {
                    OutlinedButton(onClick = {


                        insert(title, description)
                        openDialog.value = false
                        title.value=""
                        description.value=""
                    }) {

                        Text(text = "Save")

                    }
                },
                title = { Text(text = "Todo") },
                text = {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(value = title.value,
                            onValueChange = { title.value = it },
                            placeholder = {
                                Text(
                                    text = " Enter title"
                                )
                            },
                            label = { Text(text = "Title") })


                        OutlinedTextField(
                            value = description.value,
                            onValueChange = { description.value = it },
                            placeholder = {
                                Text(
                                    text = " Enter Description"
                                )
                            },
                            label = { Text(text = "Description") })

                    }
                },


                )
        }


    }

    fun insert(title: MutableState<String>, description: MutableState<String>) {

        lifecycleScope.launch {

            if (!TextUtils.isEmpty(title.value) && !TextUtils.isEmpty(description.value)) {

                todoViewModel.insert(Todo(title = title.value, description = description.value))
                Toast.makeText(this@TodoActivity, "Inserted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@TodoActivity, "Please fill", Toast.LENGTH_SHORT).show()
            }


        }


    }


    @Composable
    fun EachRow(todo: Todo) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {

            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = todo.title, fontWeight = FontWeight.Bold)
                Text(text = todo.description, fontStyle = FontStyle.Italic)
            }
        }

    }

    @Composable
    fun Recyclerview(todoViewModel: TodoViewModel) {

        LazyColumn {
            items(todoViewModel.response.value){todo->
                EachRow(todo = todo)
            }
        }
    }

}