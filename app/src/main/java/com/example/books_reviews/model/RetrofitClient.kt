package com.example.books_reviews.model

import com.example.books_reviews.interfaces.LibroApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api-review-x2nq.onrender.com"
    val api: LibroApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibroApi::class.java)
    }
}