package com.example.desafio3dh.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafio3dh.model.Thumbnail
import com.example.desafio3dh.util.Constants
import com.example.desafio3dh.databinding.ActivityComicImageBinding

class ComicImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicImageBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityComicImageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initComponents()
        setupObservables()

    }

    private fun setupObservables() {
        binding.ivZoomImgComic.setOnClickListener { finish() }
        binding.closeButton.setOnClickListener { finish() }

    }

    private fun initComponents() {
        val comicImage: Thumbnail? = intent.getParcelableExtra<Thumbnail>(Constants.Intent.KEY_COMIC_IMAGE)
        Glide.with(this)
            .load("${comicImage?.path?.replace("http","https")}.${comicImage?.extension}").into(binding.ivZoomImgComic)
    }
}