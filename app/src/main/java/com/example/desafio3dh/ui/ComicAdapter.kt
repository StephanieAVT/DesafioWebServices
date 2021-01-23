package com.example.desafio3dh.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3dh.R
import com.example.desafio3dh.models.Results
import com.squareup.picasso.Picasso

class ComicAdapter(
    val comicList: List<Results>,
    val listener: OnComicClickListener
):RecyclerView.Adapter<ComicAdapter.ComicViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_comic,parent,false)
        return ComicViewHolder(view)
}

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = comicList.get(position)
        var img = comic.images[0].path + "." + comic.images[0].extension

        holder.tvComic.text = "#" + comic.id.toString()
        Picasso.get().load(img).resize(110,150).into(holder.ivComic)
}

    override fun getItemCount(): Int {
         return comicList.size
    }

    interface OnComicClickListener{
        fun comicClick(position: Int)
    }

    inner class ComicViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{

        val ivComic: ImageView = itemView.findViewById(R.id.ivComic)
        val tvComic: TextView = itemView.findViewById(R.id.tvComic)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.comicClick(position)
        }


    }
}