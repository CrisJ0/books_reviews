package com.example.books_reviews.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.books_reviews.R

class LibroAdapter : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {

    private val libros = mutableListOf<Libro>()

    fun submitList(nuevosLibros: List<Libro>) {
        libros.clear()
        libros.addAll(nuevosLibros)
        notifyDataSetChanged()
    }

    class LibroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val portada: ImageView = view.findViewById(R.id.imageViewPortada)
        val titulo: TextView = view.findViewById(R.id.textViewTitulo)
        val autor: TextView = view.findViewById(R.id.textViewAutor)
        val descripcion: TextView = view.findViewById(R.id.textViewDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.titulo.text = libro.title
        holder.autor.text = libro.author
        holder.descripcion.text = libro.description

        // Carga simple con Coil 2.x
        holder.portada.load(libro.coverImageUrl)
    }

    override fun getItemCount() = libros.size
}