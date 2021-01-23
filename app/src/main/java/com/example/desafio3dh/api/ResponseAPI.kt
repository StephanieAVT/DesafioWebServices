package com.example.desafio3dh.api

open class ResponseAPI {
    class Success(val data: Any?) : ResponseAPI()
    class Error(val message: String) : ResponseAPI()
}