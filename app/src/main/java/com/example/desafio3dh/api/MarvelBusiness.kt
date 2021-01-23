package com.example.desafio3dh.api

import com.example.desafio3dh.api.ResponseAPI
import com.example.desafio3dh.model.Comic

class MarvelBusiness {

    private val repository by lazy {
        Repository()
    }

    suspend fun getComics(): ResponseAPI {
        val response = repository.getComics()
        return if (response is ResponseAPI.Success) {
            val hqItem = response.data as Comic
            ResponseAPI.Success(hqItem)
        } else response
    }


}