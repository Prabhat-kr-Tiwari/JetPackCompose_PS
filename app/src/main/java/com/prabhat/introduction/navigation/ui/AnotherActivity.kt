package com.prabhat.introduction.navigation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.prabhat.introduction.ui.theme.IntroductionTheme

class AnotherActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IntroductionTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    Column (modifier = Modifier.fillMaxSize().background(color = Color.Blue)){

                    }
                }
            }
        }
    }
}