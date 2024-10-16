package com.verkada.android.catpictures.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.ui.components.EnlargedImage
import com.verkada.android.catpictures.ui.components.PicSumImageGrid

@Composable
fun HomeScreen(
    selectedPicture: Picture?,
    favoritePictures: List<Picture>,
    picturesList: List<Picture>,
    addFavoritePicture: (Picture) -> Unit,
    removeFavoritePicture: (Picture) -> Unit,
    onPictureSelected: (Picture?) -> Unit // Added parameter for selecting pictures
) {
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
                nullifySelectedPicture = {}
            )
        }

        PicSumImageGrid(
            picturesList,
            modifier = Modifier.padding(2.dp),
            isSelected = { picture -> onPictureSelected(picture) },
            selectedPicture = selectedPicture
        )
    }
}
