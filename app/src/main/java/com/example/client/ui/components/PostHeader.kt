package com.example.client.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.domain.FeedPost

/**
 * @author : Mingaleev D
 * @data : 15.10.2023
 */

@Composable
fun PostHeader(
    feedPost: FeedPost
) {

      Row(
          modifier = Modifier
              .fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
      ) {

         Image(
             painter = painterResource(id = feedPost.avatarResId),
             contentDescription = null,
             modifier = Modifier
                 .size(50.dp)
                 .clip(CircleShape)
         )

         Spacer(modifier = Modifier.width(8.dp))

         Column(
             modifier = Modifier.weight(1f)
         ) {

            Text(
                text = feedPost.communityName,
                color = MaterialTheme.colors.onPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = feedPost.publishDate,
                color = MaterialTheme.colors.onPrimary
            )
         }

         Icon(
             imageVector = Icons.Default.MoreHoriz,
             contentDescription = null,
             tint = MaterialTheme.colors.onPrimary
         )
      }

}