package com.example.desafio03_marvel.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_marvel.R
import com.example.desafio03_marvel.model.Result
import com.example.desafio03_marvel.view.adapter.ComicAdapter
import com.example.desafio03_marvel.viewmodel.ViewModelComics

class MainActivity : AppCompatActivity() {

    private var results = mutableListOf<Result>()
    val recycler by lazy { findViewById<RecyclerView>(R.id.rv_comics) }
    val viewModelComic by lazy { ViewModelProviders.of(this).get(ViewModelComics::class.java) }
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_comics)

        supportActionBar?.hide()

        progressBar = findViewById(R.id.progressBar)

        val adapterComics = ComicAdapter(results, this)
        recycler.adapter = adapterComics
        val layoutManager = GridLayoutManager(this, 3)
        recycler.layoutManager = layoutManager

        //COMICS*************************
        viewModelComic.listMutableComics.observe(this, Observer {
            it.let { itComic -> results.addAll(itComic) }
            adapterComics.notifyDataSetChanged()
            Log.d("Results", results.size.toString())
        })

        Log.d("Results2", results.size.toString())
        //PROGRESS BAR*************************
        viewModelComic.loading.observe(this, Observer {
            if (it) {
                progressBar.visibility = VISIBLE
            } else {
                progressBar.visibility = GONE
            }
        })


    }


}