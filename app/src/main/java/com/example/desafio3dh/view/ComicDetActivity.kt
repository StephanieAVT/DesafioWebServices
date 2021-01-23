package com.example.desafio3dh.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.desafio3dh.model.Result
import com.example.desafio3dh.util.Constants
import com.example.desafio3dh.databinding.ActivityComicDetBinding

class ComicDetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicDetBinding
    private var comic: Result? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityComicDetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comic = intent.getParcelableExtra(Constants.Intent.KEY_COMIC_RESULT)
        initComponents()
        setupObservables()

    }

    @SuppressLint("SetText")
    private fun setupObservables() {

        binding.ivComic.setOnClickListener {
            val intent = Intent(this@ComicDetActivity, ComicImageActivity::class.java)
            intent.putExtra(Constants.Intent.KEY_COMIC_IMAGE,comic?.thumbnail)
            startActivity(intent)
        }
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
    private fun initComponents() {

        comic?.let{
            Glide.with(this).load("${it.thumbnail?.path?.replace("http","https")}.${it.thumbnail?.extension}").into(binding.ivCardComic)
            Glide.with(this).load("${it.thumbnail?.path?.replace("http","https")}.${it.thumbnail?.extension}").into(binding.ivComic)
            binding.comicTitle.text = it.title
            binding.comicDescription.text = it.description
            binding.NumPagesComic.text = it.pageCount.toString()

            binding.tvDatePublishComic.text = it.dates?.get(0).toString()
            binding.PriceValueComic.text = "$ ${it.prices?.get(0)?.price}"
        }
    }
}