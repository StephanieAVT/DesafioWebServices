package com.example.desafio3dh.api


import com.example.desafio3dh.model.Comic
import com.example.desafio3dh.util.Constants.Intent.KEY_COMIC_RESULT
import retrofit2.Response
import retrofit2.http.GET

interface MarvelAPI {
    @GET(KEY_COMIC_RESULT)
    suspend fun getComics(): Response<Comic>
}