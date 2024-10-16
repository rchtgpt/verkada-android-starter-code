package com.verkada.android.catpictures.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// object keyword creates a singleton class
object RetrofitClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(PictureService.ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val pictureService: PictureService by lazy {
        retrofit.create(PictureService::class.java)
    }
}
