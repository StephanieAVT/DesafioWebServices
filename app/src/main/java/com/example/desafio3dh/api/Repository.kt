package com.example.desafio3dh.api

import com.example.desafio3dh.api.APIService.marvelAPI
import com.example.desafio3dh.api.ResponseAPI

class Repository {

    suspend fun getComics():ResponseAPI{
        return try{
            val response = marvelAPI.getComics()

            if(response.code() == 200) {
                ResponseAPI.Success(response.body())
            }else if (response.isSuccessful) {
                ResponseAPI.Success(response.body())
            } else{
                if (response.code() == 404){
                    ResponseAPI.Error("Dados não disponíveis.")
                } else{
                    ResponseAPI.Error("Dados não disponíveis.")
                }
            }
        }catch (exception: Exception){
            ResponseAPI.Error("Falha no carregamento")
        }


    }
}