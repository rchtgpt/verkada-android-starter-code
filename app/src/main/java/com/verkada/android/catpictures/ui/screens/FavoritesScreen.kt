package com.verkada.android.catpictures.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.verkada.android.catpictures.R
import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.ui.components.EnlargedImage
import com.verkada.android.catpictures.ui.components.PicSumImageGrid

@Composable
fun FavoritesScreen(
    selectedPicture: Picture?,
    favoritePictures: List<Picture>,
    addFavoritePicture: (Picture) -> Unit,
    removeFavoritePicture: (Picture) -> Unit,
    nullifySelectedPicture: (Picture?) -> Unit,
    onPictureSelected: (Picture?) -> Unit

) {
    if (favoritePictures.isNotEmpty()) {
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            AnimatedVisibility(
                visible = (selectedPicture != null)
            ) {
                EnlargedImage(
                    selectedPicture = selectedPicture,
                    favoritePictures = favoritePictures,
                    addFavoritePicture = { addFavoritePicture(selectedPicture!!) },
                    removeFavoritePicture = { removeFavoritePicture(selectedPicture!!) },
                    nullifySelectedPicture = { picture -> nullifySelectedPicture(picture) }
                )
            }

            PicSumImageGrid(
                favoritePictures,
                modifier = Modifier.padding(2.dp),
                isSelected = { picture -> onPictureSelected(picture) },
                selectedPicture = selectedPicture
            )
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.no_items_favorited_yet),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
