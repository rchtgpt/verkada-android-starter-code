package com.verkada.android.catpictures.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.verkada.android.catpictures.R
import com.verkada.android.catpictures.data.Picture

@Composable
fun PicSumImageGrid(
    pictures: List<Picture>,
    modifier: Modifier = Modifier,
    isSelected: (Picture?) -> Unit,
    selectedPicture: Picture?
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp)
    ) {
        items(pictures) { picture ->
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clickable {
                        if (selectedPicture != picture) {
                            isSelected(picture)
                        } else {
                            isSelected(
                                null
                            )
                        }
                    }
                    .size(80.dp),
                model = picture.url,
                contentDescription = stringResource(R.string.gridImage),
                colorFilter = if (selectedPicture == picture) {
                    ColorFilter.tint(
                        Color.Green,
                        blendMode = BlendMode.Darken
                    )
                } else {
                    null
                }
            )
        }
    }
}
