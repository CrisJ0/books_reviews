package com.example.books_reviews.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.books_reviews.R


class LibroAdapter : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    private val libros = mutableListOf<Libro>()

    fun submitList(nuevosLibros: List<Libro>) {
        libros.clear()
        libros.addAll(nuevosLibros)
        notifyDataSetChanged()
    }

    class LibroViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tituloTextView)
        val autor: TextView = view.findViewById(R.id.autorTextView)
        val descripcion: TextView = view.findViewById(R.id.descripcionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.titulo.text = libro.title
        holder.autor.text = libro.author
        holder.descripcion.text = libro.description
    }

    override fun getItemCount()=libros.size
}