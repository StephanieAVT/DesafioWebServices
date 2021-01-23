package com.example.desafio3dh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
        val extension: String,
        var path: String
): Parcelable{
    fun getThumb():String{
        return "$path.$extension"
    }
}
