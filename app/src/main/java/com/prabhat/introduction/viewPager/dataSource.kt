package com.prabhat.introduction.viewPager

import androidx.annotation.DrawableRes
import com.prabhat.introduction.R

data class Pager(
    @DrawableRes val image: Int,
    val des: String
)

val dataList = listOf(
    Pager(image = R.drawable.page_one, des = "PAGE ONE"),
    Pager(image = R.drawable.page_two, des = "PAGE TWO"),
    Pager(image = R.drawable.page_one, des = "PAGE THREE"),
)