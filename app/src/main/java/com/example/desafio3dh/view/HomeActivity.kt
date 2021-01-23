package com.example.desafio3dh.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio3dh.model.Result
import com.example.desafio3dh.util.Constants.Intent.KEY_COMIC_RESULT
import com.example.desafio3dh.viewmodel.HomeViewModel
import com.example.desafio3dh.R
import com.example.desafio3dh.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setSupportActionBar(findViewById(R.id.toolbarMarvel))


        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getComics()

        setupObservables(binding)
    }

    private fun setupObservables(binding: ActivityHomeBinding) {
        // Iniciando o menu de HQs, quando ha resultados na consulta API
        viewModel.onResultComics.observe(this,{
            it?.data?.let {
                //iniciando Recycle View
                setupRecycleView(it.results)
            }
        })
        viewModel.onResultFailure.observe(this,{
            Toast.makeText(this,it, Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecycleView(lComics: List<Result>){
        binding.rvComics.apply{
            layoutManager = GridLayoutManager(this@HomeActivity,3)
            adapter = ComicAdapter(lComics){
                // adapter
                val intent = Intent(this@HomeActivity, ComicDetActivity::class.java).apply {
                    putExtra(KEY_COMIC_RESULT,it)
                    startActivity(this)
                }

                }
            }
        }

    }