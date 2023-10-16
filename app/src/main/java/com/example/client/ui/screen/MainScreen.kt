package com.example.client.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.client.domain.FeedPost
import com.example.client.ui.components.PostCard
import com.example.client.ui.navigation.BtnNavigationItem

/**
 * @author : Mingaleev D
 * @data : 16.10.2023
 */

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {

   val feedPosts = viewModel.feedPosts.observeAsState(listOf())

   Scaffold(
       bottomBar = {
          BottomNavigation {

             var selectedItemPosition by remember { mutableStateOf(0) }

             val items = listOf(
                 BtnNavigationItem.Home,
                 BtnNavigationItem.Favorites,
                 BtnNavigationItem.Profile,
             )

             items.forEachIndexed { index, btnNavigationItem ->
                BottomNavigationItem(
                    selected = selectedItemPosition == index,
                    onClick = { selectedItemPosition = index },
                    icon = {
                       Icon(
                           imageVector = btnNavigationItem.icon,
                           contentDescription = null
                       )
                    },
                    label = {
                       Text(text = stringResource(id = btnNavigationItem.titleResId))
                    },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = MaterialTheme.colors.onSecondary
                )

             }

          }
       }
   ) { padingValue ->

      LazyColumn(
          // modifier = Modifier.padding(paddingValues = padingValue),
          contentPadding = PaddingValues(8.dp),
      ) {
         items(feedPosts.value, key = { it.id }) { feedPost ->

            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
               viewModel.remove(feedPost)
            }

            SwipeToDismiss(
                state = dismissState,
                background = {},
                directions = setOf(DismissDirection.EndToStart),
                ) {

               PostCard(
                   //modifier = Modifier.padding(paddingValues = padingValue),
                   feedPost = feedPost,
                   onLikeCkickedListener = { staticItem ->
                      viewModel.updateCount(feedPost = feedPost, itemLStatisticItem = staticItem)
                   },
                   onShareCkickedListener = { staticItem ->
                      viewModel.updateCount(feedPost = feedPost, itemLStatisticItem = staticItem)
                   },
                   onViewsCkickedListener = { staticItem ->
                      viewModel.updateCount(feedPost = feedPost, itemLStatisticItem = staticItem)
                   },
                   onCommentsCkickedListener = { staticItem ->
                      viewModel.updateCount(feedPost = feedPost, itemLStatisticItem = staticItem)
                   },
               )
            }

         }
      }

   }
}