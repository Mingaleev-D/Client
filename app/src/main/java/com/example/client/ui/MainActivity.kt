package com.example.client.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.client.ui.components.PostCard
import com.example.client.ui.screen.MainScreen
import com.example.client.ui.screen.MainViewModel
import com.example.client.ui.theme.ClientTheme

class MainActivity : ComponentActivity() {

   private val viewModel by viewModels<MainViewModel>()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         ClientTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(8.dp)

            ) {

               MainScreen(viewModel = viewModel)
            }

         }
      }
   }
}

