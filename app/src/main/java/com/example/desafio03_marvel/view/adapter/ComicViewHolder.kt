package com.example.desafio03_marvel.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_marvel.R

class ComicViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    val comicImage : ImageView =itemView.findViewById(R.id.iv_card_comic)
    val comicNumber : TextView = itemView.findViewById(R.id.tv_card_comic_number)

}