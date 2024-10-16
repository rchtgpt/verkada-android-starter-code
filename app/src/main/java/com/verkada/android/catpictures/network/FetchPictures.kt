package com.verkada.android.catpictures.network

import com.verkada.android.catpictures.data.Picture

class FetchPictures {
    private val pictureService: PictureService = RetrofitClient.pictureService

    suspend fun getPictures(page: Int): List<Picture> {
        return pictureService.pictures(page)
    }
}
