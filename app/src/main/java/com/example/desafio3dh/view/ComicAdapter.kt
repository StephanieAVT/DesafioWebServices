package com.example.desafio3dh.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafio3dh.model.Result
import com.example.desafio3dh.databinding.RvItemComicBinding

class ComicAdapter(
    private val comicList: List<Result>,
    private val listener: (Result) -> Unit
) : RecyclerView.Adapter<ComicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemComicBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comic = comicList[position], listener)
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    class ViewHolder( private val binding:RvItemComicBinding):RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bind(comic: Result, comicOnClicked: (Result) -> Unit) = with(binding){
            Glide.with(itemView.context)
                .load("${comic.thumbnail?.path?.replace("http","https")}.${comic.thumbnail?.extension}")
                .into(ivComic)

            val issueNumber = comic.issueNumber?.toInt().toString()
            tvComic.text = "#$issueNumber"

            itemView.setOnClickListener {
                comicOnClicked(comic)
            }
        }
    }
}