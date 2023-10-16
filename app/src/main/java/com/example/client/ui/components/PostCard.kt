package com.example.client.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R
import com.example.client.domain.FeedPost
import com.example.client.domain.StatisticItem
import com.example.client.domain.StatisticType
import com.example.client.ui.theme.ClientTheme

/**
 * @author : Mingaleev D
 * @data : 15.10.2023
 */

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onLikeCkickedListener: (StatisticItem) -> Unit,
    onShareCkickedListener: (StatisticItem) -> Unit,
    onViewsCkickedListener: (StatisticItem) -> Unit,
    onCommentsCkickedListener: (StatisticItem) -> Unit
) {

   Card(
       elevation = 4.dp,
       modifier = modifier
   ) {
      Column(
          modifier = Modifier.padding(8.dp)
      ) {

         PostHeader(
             feedPost = feedPost
         )

         Spacer(modifier = Modifier.height(8.dp))

         Text(
             text = feedPost.contentString,
             color = MaterialTheme.colors.onPrimary,
             maxLines = 2
         )

         Spacer(modifier = Modifier.height(8.dp))

         Image(
             painter = painterResource(id = feedPost.contentImageResId),
             contentDescription = null,
             modifier = Modifier.fillMaxWidth(),
             contentScale = ContentScale.FillWidth
         )

         Spacer(modifier = Modifier.height(8.dp))

         Statistics(
             statistics = feedPost.statistics,
             onLikeCkickedListener = onLikeCkickedListener,
             onShareCkickedListener = onShareCkickedListener,
             onViewsCkickedListener = onViewsCkickedListener,
             onCommentsCkickedListener = onCommentsCkickedListener
         )
      }

   }
}

@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
    onLikeCkickedListener: (StatisticItem) -> Unit,
    onShareCkickedListener: (StatisticItem) -> Unit,
    onViewsCkickedListener: (StatisticItem) -> Unit,
    onCommentsCkickedListener: (StatisticItem) -> Unit
) {

   Row {
      Row(
          modifier = Modifier.weight(1f),
      ) {

         val viewsItem = statistics.getItemByType(StatisticType.VIEWS)

         IconWithText(
             iconResId = Icons.Default.Visibility,
             text = viewsItem.count.toString(),
             onItemClickedListener = {
                onViewsCkickedListener(viewsItem)
             }

         )
      }

      Row(
          modifier = Modifier.weight(1f),
          horizontalArrangement = Arrangement.SpaceBetween
      ) {

         val shareItem = statistics.getItemByType(StatisticType.SHARES)
         IconWithText(
             iconResId = Icons.Outlined.ArrowOutward,
             text = shareItem.count.toString(),
             onItemClickedListener = {
                onShareCkickedListener(shareItem)
             })

         val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
         IconWithText(
             iconResId = Icons.Default.Comment,
             text = commentsItem.count.toString(),
             onItemClickedListener = {
                onCommentsCkickedListener(commentsItem)
             })

         val likesItem = statistics.getItemByType(StatisticType.LIKES)
         IconWithText(
             iconResId = Icons.Default.FavoriteBorder,
             text = likesItem.count.toString(),
             onItemClickedListener = {
                onLikeCkickedListener(likesItem)
             })
      }
   }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
   return this.find { it.type == type } ?: throw IllegalStateException("Statistic item not found")
}

@Composable
private fun IconWithText(
    iconResId: ImageVector,
    text: String,
    onItemClickedListener: () -> Unit = {}
) {

   Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically,
       modifier = Modifier.clickable {
          onItemClickedListener()
       }
   ) {
      Icon(
          imageVector = iconResId, contentDescription = null,
          tint = MaterialTheme.colors.onPrimary
      )

      Spacer(modifier = Modifier.width(4.dp))

      Text(
          text = text,
          color = MaterialTheme.colors.onPrimary,
          fontSize = 16.sp
      )
   }

}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun PostCardPreview() {
   ClientTheme {
      // PostCard()
   }
}