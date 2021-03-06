package com.example.desafio3dh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
        val extension: String,
        var path: String?
): Parcelable