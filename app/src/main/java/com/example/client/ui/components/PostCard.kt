package com.example.client.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
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
import com.example.client.ui.theme.ClientTheme

/**
 * @author : Mingaleev D
 * @data : 15.10.2023
 */

@Composable
fun PostCard() {

   Card(
       elevation = 4.dp
   ) {
      Column(
          modifier = Modifier.padding(8.dp)
      ) {

         PostHeader()

         Spacer(modifier = Modifier.height(8.dp))

         Text(
             text = "Demo text",
             color = MaterialTheme.colors.onPrimary,
             maxLines = 2
         )

         Spacer(modifier = Modifier.height(8.dp))

         Image(
             painter = painterResource(id = R.drawable.apple),
             contentDescription = null,
             modifier = Modifier.fillMaxWidth(),
             contentScale = ContentScale.FillWidth
         )

         Spacer(modifier = Modifier.height(8.dp))

         Statistics()
      }

   }
}

@Composable
private fun Statistics() {

   Row(

   ) {

      Row(
          modifier = Modifier.weight(1f),
      ) {
         IconWithText(iconResId = Icons.Default.Visibility, text = "12")
      }

      Row(
          modifier = Modifier.weight(1f),
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
         IconWithText(iconResId = Icons.Outlined.ArrowOutward, text = "12")
         IconWithText(iconResId = Icons.Default.Comment, text = "12")
         IconWithText(iconResId = Icons.Default.FavoriteBorder, text = "12")
      }
   }
}

@Composable
private fun IconWithText(
    iconResId: ImageVector,
    text: String
) {

   Row(
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically
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
      PostCard()
   }
}