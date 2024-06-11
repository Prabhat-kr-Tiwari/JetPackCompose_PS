package com.prabhat.introduction

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prabhat.introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroductionTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                     , topBar = {
                        TopAppBar(modifier = Modifier.background(color = Color.Red)
                            ,  colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
                            , title = {
                            Text(text = "Demo App")

                        }, navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
                            }
                        }, actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Notifications,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                            }
                        }
                        )
                    }, floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Filled.Add, contentDescription = "")

                            }

                        }
                    }

                ) { innerPadding ->
                    innerPadding

                    Row(modifier = Modifier.fillMaxSize().background(color = Red),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

                        ShowSwitch()
                    }
                }
            }
        }
    }
}

@Composable

fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,

        )
}

@Preview(showSystemUi = true, showBackground = true, name = "light mode")
@Preview(
    showBackground = true, name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    IntroductionTheme {
        Greeting("Android")
    }
}

@Composable
fun ShowSwitch() {

    val isChecked = remember {
        mutableStateOf(true)
    }
    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = Modifier
            .size(40.dp)
//            .padding(100.dp)



    )
}