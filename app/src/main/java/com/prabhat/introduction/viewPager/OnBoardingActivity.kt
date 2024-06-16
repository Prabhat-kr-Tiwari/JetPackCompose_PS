package com.prabhat.introduction.viewPager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.prabhat.introduction.ui.theme.IntroductionTheme

class OnBoardingActivity:ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IntroductionTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    OnBoardingScreen()
                }
            }
        }
    }
}