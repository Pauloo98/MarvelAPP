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
import com.example.desafio03_marvel.view.adapter.RecycleScroll
import com.example.desafio03_marvel.viewmodel.ViewModelComics

class MainActivity : AppCompatActivity() {

    private var results = mutableListOf<Result>()
    val recycler by lazy { findViewById<RecyclerView>(R.id.rv_comics) }
    val viewModelComic by lazy { ViewModelProviders.of(this).get(ViewModelComics::class.java) }
    lateinit var firstProgressBar: ProgressBar
    lateinit var nextProgressBar: ProgressBar
    private val recyclerScrollListener by lazy {
        RecycleScroll {
            viewModelComic.requestMoreComics()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_comics)

        supportActionBar?.hide()

        firstProgressBar = findViewById(R.id.progressBar)
        nextProgressBar = findViewById(R.id.progressBar2)


        val adapterComics = ComicAdapter()
        recycler.adapter = adapterComics
        val layoutManager = GridLayoutManager(this, 3)
        recycler.layoutManager = layoutManager
        recycler.addOnScrollListener(recyclerScrollListener)

        //COMICS*************************

        Log.d("Results2", results.size.toString())

        viewModelComic.listMutableComics.observe(this, Observer {
            setRequestingNextPage()
            adapterComics.addComics(it)
        })




        //PROGRESS BAR*************************
        viewModelComic.firstPageLoading.observe(this, Observer {
            if (it) {
                firstProgressBar.visibility = VISIBLE
            } else {
                firstProgressBar.visibility = GONE
            }
        })

        viewModelComic.nextPageLoading.observe(this, Observer {
            if (it) {
                if(firstProgressBar.visibility == VISIBLE){
                    nextProgressBar.visibility = GONE
                } else nextProgressBar.visibility = VISIBLE
            } else {
                nextProgressBar.visibility = GONE
            }
        })


    }


    private fun setRequestingNextPage() {
        recyclerScrollListener.requesting = false
    }



}