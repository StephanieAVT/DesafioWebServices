package com.example.desafio3dh.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.desafio3dh.R
import com.example.desafio3dh.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_details.*
import kotlinx.android.synthetic.main.fragment_comic_details.view.*

class ComicDetailsFragment : Fragment() {

    lateinit var contractF: ContractF
    lateinit var imgZoom:String
    private val hqImage: ImageView by lazy {ivComic}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comic_details, container, false)

        view.toolbarFrag.setOnClickListener {
            contractF.removeFrag()
        }

        val comic = requireArguments().getSerializable("comic") as Results


        var imgFrag = comic.images[0].path + "." + comic.images[0].extension

        if (comic.images.size > 1){
            imgZoom = comic.images[1].path + "." + comic.images[1].extension

        }else{
            imgZoom = imgFrag
        }


        view.comicTitle.text = comic.title.toUpperCase()
        view.comicDescription.text = comic.description
        view.tvDatePublishComic.text = comic.dates[0].date.split("T")[0]
        view.PriceValueComic.text = "$" + comic.prices[0].price.toString()
        view.NumPagesComic.text = comic.pageCount.toString()


        Picasso.get().load(imgFrag).resize(110,150).into(view.ivComic)
        Picasso.get().load(imgZoom).resize(415,250).into(view.ivCardComic)

        view.ivComic.setOnClickListener {
            contractF.callImage(imgFrag)
        }

        return view
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractF) contractF = context
    }

    companion object {
        fun newInstance() = ComicDetailsFragment()

    }
}