package com.jsrm.dogedex.dogList

import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.internetConection.DogsApi.retrofitService
import com.jsrm.dogedex.internetConection.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}