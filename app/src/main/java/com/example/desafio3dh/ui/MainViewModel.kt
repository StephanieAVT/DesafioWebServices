package com.example.desafio3dh.ui



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio3dh.api.Service
import com.example.desafio3dh.models.Res
import kotlinx.coroutines.launch

class MainViewModel(val service: Service):ViewModel() {
   var retorno = MutableLiveData<Res>()


    fun getComicsRepo(){
        viewModelScope.launch {
            retorno.value = service.getComicsRepo(
                1,
                10,
                "1",
                "19cec655f0cd0b638d1b984a4cb483ad",
                "04368b032ac462986231cdfed6c78a56"
                //"04368b032ac462986231cdfed6c78a56"



            )
            Log.i("TAG", retorno.value.toString())
        }

    }

//    fun getComicsRepo(){
//        viewModelScope.launch {
//            retorno.value = service.getComicsRepo(
//                    1,
//                    10,
//                    "1",
//                "54601a1cc51e454d3f67312d07922bff",
//                    "04368b032ac462986231cdfed6c78a56"
//            )
//            Log.i("TAG", retorno.value.toString())
//        }
//
//    }

}