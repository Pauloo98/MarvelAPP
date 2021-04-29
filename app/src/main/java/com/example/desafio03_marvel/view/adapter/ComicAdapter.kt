package com.example.desafio03_marvel.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_marvel.R
import com.example.desafio03_marvel.model.Comics
import com.example.desafio03_marvel.model.Result
import com.example.desafio03_marvel.view.activity.DetailsActivity
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//class ComicAdapter(
//    private val list: List<Result>,
//    private val context: Context
//) : RecyclerView.Adapter<ComicViewHolder>() {

class ComicAdapter : RecyclerView.Adapter<ComicViewHolder>() {
    val list = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_comic, parent, false)
        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = list.elementAt(position)
        Picasso.get().load(comic.thumbnail.path + ".jpg").resize(95,125).into(holder.comicImage)
        Log.d("Poster", comic.thumbnail.path.toString() + ".jpg")
        holder.comicNumber.text = "# " + position.toString()


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("title", comic.title)
            intent.putExtra("description", comic.description)
            intent.putExtra("release", comic.dates[0].date)
            intent.putExtra("price", comic.prices[0].price)
            intent.putExtra("pages", comic.pageCount)
            intent.putExtra("photo", comic.thumbnail.path)
            Log.d("PutExtras", comic.id)
            it.context.startActivity(intent)
        }

    }

    fun addComics(comics : List<Result>){
        list.addAll(comics)
        notifyDataSetChanged()
    }


}