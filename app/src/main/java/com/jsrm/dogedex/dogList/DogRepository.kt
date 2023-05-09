package com.jsrm.dogedex.dogList

import com.jsrm.dogedex.model.Dog
import com.jsrm.dogedex.internetConection.DogsApi.retrofitService
import com.jsrm.dogedex.internetConection.ResponseStatus
import com.jsrm.dogedex.internetConection.dto.DogDTOMapper
import com.jsrm.dogedex.internetConection.makeNetworkCall

class DogRepository {

    suspend fun downloadDogs(): ResponseStatus<List<Dog>> = makeNetworkCall {
        val dogListApiResponse = retrofitService.getAllDogs()
        val dogDTOList = dogListApiResponse.data.dogs
        val dogDTOMapper = DogDTOMapper()
        dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
    }
}