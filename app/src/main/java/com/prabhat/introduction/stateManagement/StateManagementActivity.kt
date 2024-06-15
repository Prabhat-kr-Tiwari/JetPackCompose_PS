package com.prabhat.introduction.stateManagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prabhat.introduction.ui.theme.IntroductionTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StateManagementActivity : ComponentActivity() {


    private val stateViewModel:StateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    ShowWidget()
                }
            }
        }
    }

    @Composable
    fun ShowWidget() {

       /* val name = remember {
            mutableStateOf("")
        }*/
        val name = rememberSaveable {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

/*
            if(name.value.isNotEmpty()){
                Text(text = name.value, color = Color.Yellow)
            }*/

            if (stateViewModel.name.value.isNotEmpty()){
                Text(text = stateViewModel.name.value, color = Color.Yellow)
            }

            OutlinedTextField(value = name.value, onValueChange ={
                name.value=it
            }, label = {
                Text(text = "Name")
            } )

        }
    }
}