package com.example.desafio3dh.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
        val price: Double?,
        val type: String?
): Parcelable
