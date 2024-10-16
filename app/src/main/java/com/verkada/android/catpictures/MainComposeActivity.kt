package com.verkada.android.catpictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.network.FetchPictures
import com.verkada.android.catpictures.theme.CatPicturesTheme
import com.verkada.android.catpictures.ui.components.BottomNavigationBar
import com.verkada.android.catpictures.ui.screens.FavoritesScreen
import com.verkada.android.catpictures.ui.screens.HomeScreen
import kotlinx.coroutines.launch

class MainComposeActivity : ComponentActivity() {
    private val fetchPictures = FetchPictures()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatPicturesTheme {
                var selected by remember { mutableStateOf(0) }
                var picturesList by remember { mutableStateOf<List<Picture>>(emptyList()) }
                var selectedPicture by remember { mutableStateOf<Picture?>(null) }
                var favoritePictures by remember { mutableStateOf<List<Picture>>(emptyList()) }

                // Make the API call in a coroutine to fetch pictures and update state
                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        val fetchedPictures = fetchPictures.getPictures(page = 1)
                        picturesList = fetchedPictures // Update the state with fetched pictures
                    }
                }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            selected = selected,
                            onItemSelected = { selected = it },
                            nullifySelectedPicture = { selectedPicture = it }
                        )
                    }
                ) {
                        innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (selected) {
                            0 -> HomeScreen(
                                selectedPicture = selectedPicture,
                                favoritePictures = favoritePictures,
                                picturesList = picturesList,
                                addFavoritePicture = { favoritePictures += it },
                                removeFavoritePicture = { favoritePictures -= it },
                                onPictureSelected = { selectedPicture = it }
                            )
                            1 -> FavoritesScreen(
                                selectedPicture = selectedPicture,
                                favoritePictures = favoritePictures,
                                addFavoritePicture = { favoritePictures += it },
                                removeFavoritePicture = { favoritePictures -= it },
                                nullifySelectedPicture = { selectedPicture = it },
                                onPictureSelected = { selectedPicture = it }
                            )
                        }
                    }
                }
            }
        }
    }
}
