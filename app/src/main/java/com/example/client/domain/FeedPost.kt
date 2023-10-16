package com.example.client.domain

import com.example.client.R

data class FeedPost(
    val id: Int = 1,
    val communityName: String = "demo text",
    val publishDate: String = "14 : 00",
    val avatarResId: Int = R.drawable.photo,
    val contentString: String = "Demo text",
    val contentImageResId: Int = R.drawable.apple,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(
            type = StatisticType.VIEWS,
            count = 12
        ),
        StatisticItem(
            type = StatisticType.SHARES,
            count = 12
        ),
        StatisticItem(
            type = StatisticType.COMMENTS,
            count = 12
        ),
        StatisticItem(
            type = StatisticType.LIKES,
            count = 12
        ),
    )
)
