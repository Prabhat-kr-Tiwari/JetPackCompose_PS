package com.prabhat.introduction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prabhat.introduction.ui.theme.IntroductionTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionTheme {

                Surface(color = MaterialTheme.colorScheme.background) {

                    LoginScreen()

                }
            }
        }
    }
    private fun logged(username:String,password:String){
        if (username=="jks"&&password=="12345"){
            Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "wrong credentials", Toast.LENGTH_SHORT).show()
        }

    }

    @Composable
    fun LoginScreen() {

        val username = remember {

            mutableStateOf("")
        }
        val password = remember {

            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello Again",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "Welcome",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "Back",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace
            )


            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                label = {
                    Text(
                        text = "Username"
                    )
                }, placeholder = {
                    Text(
                        text = "Enter username"
                    )
                }, modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
                label = {
                    Text(
                        text = "Password"
                    )
                }, placeholder = {
                    Text(
                        text = "Enter Password"
                    )
                }, modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(onClick = { logged(username.value,password.value) }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")
            }


        }
    }
}