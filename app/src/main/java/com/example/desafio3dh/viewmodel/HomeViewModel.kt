package com.example.desafio3dh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.example.desafio3dh.api.ResponseAPI
import com.example.desafio3dh.model.Comic
import com.example.desafio3dh.api.MarvelBusiness
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    val onResultComics: MutableLiveData<Comic> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MarvelBusiness()
    }

    fun getComics() {
        viewModelScope.launch {
            when (val response = business.getComics()){
                is ResponseAPI.Success-> {
                    onResultComics.postValue(
                        response.data as Comic
                    )
                }
                is ResponseAPI.Error ->{
                    onResultFailure.postValue(response.message)
                }
            }
        }

    }


}