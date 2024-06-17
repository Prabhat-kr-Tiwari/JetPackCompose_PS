package com.prabhat.introduction.navigation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.prabhat.introduction.navigation.utils.NavigationScreen

@Composable
fun ThirdScreen(navHostController: NavHostController) {


    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Third Screen")


    }


}