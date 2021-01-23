package com.example.desafio3dh.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
        val available: Int,
        val collectionURI: String,
        val returned: Int
): Parcelable
