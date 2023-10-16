package com.example.client.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.client.domain.FeedPost
import com.example.client.domain.StatisticItem

/**
 * @author : Mingaleev D
 * @data : 16.10.2023
 */

class MainViewModel : ViewModel() {

   private val sourseList = mutableListOf<FeedPost>().apply {
      repeat(10) {
         add(FeedPost(id = it))
      }
   }

   private val _feedPosts = MutableLiveData<List<FeedPost>>(sourseList)
   val feedPosts: LiveData<List<FeedPost>> = _feedPosts

   fun updateCount(itemLStatisticItem: StatisticItem, feedPost: FeedPost) {

      val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
      val oldStatistics = feedPost.statistics

      val newStatistics = oldStatistics.toMutableList().apply {
         replaceAll { oldItem ->
            if (oldItem.type == itemLStatisticItem.type) {
               oldItem.copy(count = oldItem.count + 1)
            } else {
               oldItem
            }
         }
      }
      val newsFeedPost = feedPost.copy(statistics = newStatistics)
      _feedPosts.value = oldPosts.apply {
         replaceAll {
            if (it.id == newsFeedPost.id) newsFeedPost else it
         }
      }
   }

   fun remove(feedPost: FeedPost) {
      val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
      oldPosts.remove(feedPost)
      _feedPosts.value = oldPosts
   }
}