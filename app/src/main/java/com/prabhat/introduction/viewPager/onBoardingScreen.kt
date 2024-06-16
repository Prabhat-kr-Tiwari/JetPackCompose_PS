package com.prabhat.introduction.viewPager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.prabhat.introduction.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {

    val pageState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { dataList.size }
    )

    Column {
        HorizontalPager(
            state = pageState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            PageUi(pager = dataList[page])


        }
        HorizontalPagerIndicator(
            pageState, dataList.size, Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            activeColor = colorResource(id = R.color.teal_200)
        )
        AnimatedVisibility(visible = pageState.currentPage==2) {
            Button(onClick ={} , modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
                
            }
            
        }

    }

}

@Composable
fun PageUi(pager: Pager) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = pager.image),
            contentDescription = pager.des,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pager.des)


    }
}