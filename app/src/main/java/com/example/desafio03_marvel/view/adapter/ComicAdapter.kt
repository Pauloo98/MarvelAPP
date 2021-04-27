package com.example.desafio03_marvel.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_marvel.R
import com.example.desafio03_marvel.model.Result
import com.example.desafio03_marvel.view.activity.DetailsActivity
import com.squareup.picasso.Picasso

class ComicAdapter(
        private val list: List<Result>,
        private val context: Context
) : RecyclerView.Adapter<ComicViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_comic, parent, false)
        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = list.elementAt(position)
        Picasso.get().load(comic.thumbnail.path + ".jpg").into(holder.comicImage)
        Log.d("Poster", comic.thumbnail.path.toString() + ".jpg")
        holder.comicNumber.text =  "# " + position.toString()


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("title", comic.title)
            intent.putExtra("description", comic.description)
            intent.putExtra("release", comic.dates[0].toString())
            intent.putExtra("price", comic.prices.toString())
            intent.putExtra("pages", comic.pageCount)






        }

    }







}