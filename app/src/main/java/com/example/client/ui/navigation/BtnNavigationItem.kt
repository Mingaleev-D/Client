package com.example.client.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.client.R

/**
 * @author : Mingaleev D
 * @data : 16.10.2023
 */

sealed class BtnNavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {

   object Home : BtnNavigationItem(
       titleResId = R.string.home,
       icon = Icons.Outlined.Home
   )

   object Favorites : BtnNavigationItem(
       titleResId = R.string.favorites,
       icon = Icons.Outlined.FavoriteBorder
   )

   object Profile : BtnNavigationItem(
       titleResId = R.string.profile,
       icon = Icons.Outlined.Person
   )
}