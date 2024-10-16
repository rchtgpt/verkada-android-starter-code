package com.verkada.android.catpictures.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.verkada.android.catpictures.R
import com.verkada.android.catpictures.data.Picture

@Composable
fun EnlargedImage(
    selectedPicture: Picture?,
    favoritePictures: List<Picture>,
    addFavoritePicture: (Picture) -> Unit,
    removeFavoritePicture: (Picture) -> Unit,
    nullifySelectedPicture: (Picture?) -> Unit
) {
    if (selectedPicture == null) {
        return
    }

    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        AsyncImage(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(horizontal = 45.dp, vertical = 5.dp),
            contentScale = ContentScale.Crop,
            model = selectedPicture.url,
            contentDescription = stringResource(R.string.selectedImage)
        )
        Icon(
            modifier =
            Modifier
                .size(40.dp)
                .align(Alignment.BottomEnd)
                .clickable {
                    if (selectedPicture !in favoritePictures) {
                        addFavoritePicture(
                            selectedPicture
                        )
                    } else {
                        removeFavoritePicture(selectedPicture)
                        nullifySelectedPicture(null)
                    }
                },
            imageVector = if (selectedPicture !in favoritePictures) Icons.Outlined.FavoriteBorder else Icons.Outlined.Favorite,
            contentDescription =
            stringResource(
                R.string.heartIcon
            )
        )
    }
}
