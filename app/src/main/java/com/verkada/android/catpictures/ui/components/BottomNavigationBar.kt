package com.verkada.android.catpictures.ui.components

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.verkada.android.catpictures.R
import com.verkada.android.catpictures.data.Picture

@Composable
fun BottomNavigationBar(
    selected: Int,
    onItemSelected: (Int) -> Unit,
    nullifySelectedPicture: (Picture?) -> Unit
) {
    androidx.compose.material.BottomNavigation {
        BottomNavigationItem(
            selected = selected == 0,
            onClick = {
                onItemSelected(0)
                nullifySelectedPicture(null)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(R.string.home)
                )
            },
            label = {
                Text(text = stringResource(R.string.home))
            }
        )
        BottomNavigationItem(
            selected = selected == 1,
            onClick = {
                onItemSelected(1)
                nullifySelectedPicture(null)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = stringResource(R.string.favorites)
                )
            },
            label = {
                Text(text = stringResource(R.string.favorites))
            }
        )
    }
}
