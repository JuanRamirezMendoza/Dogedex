package com.jsrm.dogedex.dogList

import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.internetConection.DogsApi.retrofitService
import com.jsrm.dogedex.internetConection.ResponseStatus
import com.jsrm.dogedex.internetConection.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.UnknownHostException

class DogRepository {

    suspend fun downloadDogs(): ResponseStatus<List<Dog>>{
        return withContext(Dispatchers.IO) {
            try {
                val dogListApiResponse = retrofitService.getAllDogs()
                val dogDTOList = dogListApiResponse.data.dogs
                val dogDTOMapper = DogDTOMapper()
                ResponseStatus.Success(dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList))
            } catch (e: UnknownHostException) {
                ResponseStatus.Error("No hay internet")
            } catch (e: Exception) {
                ResponseStatus.Error("Error desconocido")
            }
        }
    }
}