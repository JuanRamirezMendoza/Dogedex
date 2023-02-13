package com.jsrm.dogedex.dogList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.internetConection.ResponseStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val _status = MutableLiveData<ResponseStatus<List<Dog>>>()
    val status: LiveData<ResponseStatus<List<Dog>>>
        get() = _status

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _status.value = ResponseStatus.Loading()
            handleResponseStatus(dogRepository.downloadDogs())
        }
    }

    private fun handleResponseStatus(responseStatus: ResponseStatus<List<Dog>>) {
        if (responseStatus is ResponseStatus.Success){
            _dogList.value = responseStatus.data
        }
        _status.value = responseStatus
    }
}