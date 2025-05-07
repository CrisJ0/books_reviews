package com.example.books_reviews.interfaces

import com.example.books_reviews.model.Libro
import retrofit2.http.GET
import retrofit2.http.Query

interface LibroApi {
    @GET("api/libros")
    suspend fun getLibrosPorCategoria(@Query("categoria") categoria: String): List<Libro>
}