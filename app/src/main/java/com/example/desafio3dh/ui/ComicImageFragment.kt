package com.example.desafio3dh.ui

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import com.example.desafio3dh.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_image.view.*

class ComicImageFragment : Fragment() {

    lateinit var  contract:ContractF

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_comic_image, container, false)
        view.findViewById<Toolbar>(R.id.tbFragmentImg).setNavigationOnClickListener() {
            contract.removeFrag()
        }

        var img = requireArguments().getString("img")
        Picasso.get().load(img).resize(370,570).into(view.ivZoomImgComic)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractF) contract = context
    }
    companion object{
        fun newInstance() = ComicImageFragment()
    }
}