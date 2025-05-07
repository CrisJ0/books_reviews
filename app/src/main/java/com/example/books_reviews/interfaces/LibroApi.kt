package com.example.books_reviews.interfaces

import com.example.books_reviews.model.Libro
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LibroApi {
    @Headers("Content-Type: application/json")
    @POST("/books/category")
    suspend fun getLibrosPorCategoria(@Body categoria: String): List<Libro>
}