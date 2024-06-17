package com.prabhat.introduction.navigation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prabhat.introduction.navigation.screen.FirstScreen
import com.prabhat.introduction.navigation.screen.SecondScreen
import com.prabhat.introduction.navigation.screen.ThirdScreen
import com.prabhat.introduction.navigation.utils.NavigationScreen

@Composable
fun StartNavigation(context:Activity) {


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.FirstScreen.route) {
        composable(NavigationScreen.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(NavigationScreen.SecondScreen.route){
            val data=it.arguments?.getString("data")
            SecondScreen(context,navController)
        }
        composable(NavigationScreen.ThirdScreen.route){
            ThirdScreen(navController)
        }


    }

}