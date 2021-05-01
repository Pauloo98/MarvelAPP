package com.example.desafio03_marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio03_marvel.model.Comics
import com.example.desafio03_marvel.model.Result
import com.example.desafio03_marvel.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class ViewModelComics : ViewModel() {

    val listMutableComics = MutableLiveData<List<Result>>()
    val firstPageLoading = MutableLiveData<Boolean>()
    val nextPageLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    private val repository = RepositoryApi()
    var moreComics: Int = 0


    init {
        getAllComics()
    }


    fun getAllComics() = CoroutineScope(IO).launch {
        firstPageLoading.postValue(true)
        try {
            repository.getComicsService().let { comicsResponse ->
                updateMoreComics(comicsResponse)
                listMutableComics.postValue(comicsResponse.data.results)
                firstPageLoading.postValue(false)
            }
        } catch (error: Throwable) {
            firstPageLoading.postValue(false)
            handleError(error)
        }
    }


    private fun handleError(error: Throwable) {
        when (error) {
            is HttpException -> errorMessage.postValue("Erro de conexão código: ${error.code()}")
            is UnknownHostException -> errorMessage.postValue("Verifique sua conexão")
        }
    }

    private fun updateMoreComics(comics: Comics) {
        moreComics = comics.data.offset.toInt().plus(17)
    }

    fun requestMoreComics() = CoroutineScope(IO).launch {
        nextPageLoading.postValue(true)
        try {
            repository.getComicsService(moreComics).let { comicsResponse ->
                updateMoreComics(comicsResponse)
                listMutableComics.postValue(comicsResponse.data.results)
                nextPageLoading.postValue(false)
            }
        } catch (error: Throwable) {
            handleError(error)
        }
    }


}