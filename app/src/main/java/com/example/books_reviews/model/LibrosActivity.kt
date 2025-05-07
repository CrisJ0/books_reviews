package com.example.books_reviews.model

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.books_reviews.R
import kotlinx.coroutines.launch

class LibrosActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private val adapter = LibroAdapter()

    private val categorias = listOf("Drama", "Cooking", "Science", "History")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        spinner = findViewById(R.id.spinnerCategorias)
        recyclerView = findViewById(R.id.recyclerViewLibros)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val categoriaSeleccionada = categorias[position]
                cargarLibros(categoriaSeleccionada)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun cargarLibros(categoria: String) {
        lifecycleScope.launch {
            try {
                val libros = RetrofitClient.api.getLibrosPorCategoria(categoria)
                adapter.submitList(libros)
            } catch (e: Exception) {
                Toast.makeText(this@LibrosActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
            }
        }
}