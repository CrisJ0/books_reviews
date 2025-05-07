package com.example.books_reviews.model

import com.example.books_reviews.interfaces.LibroApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://tu-backend.com/"  // <-- Reemplaza con la URL de tu backend real

    val api: LibroApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // URL base de tu API
            .addConverterFactory(GsonConverterFactory.create())  // Para convertir JSON a objetos
            .build()
            .create(LibroApi::class.java)  // Usa la interfaz que creaste para Retrofit (LibroApi)
    }
}