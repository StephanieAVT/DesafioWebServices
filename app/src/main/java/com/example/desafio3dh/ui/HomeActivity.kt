package com.example.desafio3dh.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio3dh.R
import com.example.desafio3dh.api.service
import com.example.desafio3dh.models.Results
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),ComicAdapter.OnComicClickListener,ContractF {

    val fragDetComic = ComicDetailsFragment.newInstance()
    val fragEmpt = VFragment.newInstance()
    val fragImg = ComicImageFragment.newInstance()


    lateinit var bundle: Bundle

    lateinit var adapterComics: ComicAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    var retornoComics = arrayListOf<Results>()

    val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbarMarvel)

        gridLayoutManager = GridLayoutManager(this,3)
        rvComics.layoutManager = gridLayoutManager

        viewModel.retorno.observe(this){
            retornoComics.addAll(it.data.results)
            adapterComics = ComicAdapter(retornoComics,this)
            rvComics.adapter = adapterComics
        }

        viewModel.getComicsRepo()


    }

    override fun comicClick(position: Int){
        viewModel.retorno.observe(this){
            val comic = retornoComics.get(position)
            bundle = Bundle()
            adapterComics.notifyItemChanged(position)

            bundle.putSerializable("comic", comic)
            supportFragmentManager.beginTransaction().apply{
                add(R.id.fldetails, fragDetComic::class.java, bundle)
                commit()}
        }

    }
    override fun callImage(img:String){
        bundle = Bundle()
        bundle.putString("img", img)
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fldetails,fragImg::class.java, bundle)
            commit()}
    }
    override fun removeFrag(){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fldetails,fragEmpt )
            commit()}

        supportFragmentManager.beginTransaction().apply{
            remove(fragEmpt)
            commit() }
    }
}