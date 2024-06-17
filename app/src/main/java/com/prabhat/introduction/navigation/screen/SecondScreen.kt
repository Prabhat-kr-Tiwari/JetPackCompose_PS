package com.prabhat.introduction.navigation.screen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.prabhat.introduction.navigation.ui.AnotherActivity
import com.prabhat.introduction.navigation.utils.NavigationScreen

@Composable
fun SecondScreen(context:Activity,navHostController: NavHostController) {

    val localContext= LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Red)) {
        Text(text = "Second Screen")

        Button(onClick = {
          /*  val intent=Intent(localContext,AnotherActivity::class.java)
            localContext.startActivity(intent)*/
            /*navHostController.navigate(NavigationScreen.ThirdScreen.route){
                popUpTo(NavigationScreen.FirstScreen.route)
            }*/

            
           /* navHostController.navigate(NavigationScreen.ThirdScreen.route){
                popUpTo(NavigationScreen.FirstScreen.route){
                    inclusive=false
                }
            }*/

             navHostController.navigate(NavigationScreen.ThirdScreen.route){
                popUpTo(NavigationScreen.FirstScreen.route){
                    inclusive=true
                }
            }


        }) {

            Text(text ="Go to Another Activity" )
        }
    }

}