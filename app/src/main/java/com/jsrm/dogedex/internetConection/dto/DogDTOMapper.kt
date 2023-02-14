package com.jsrm.dogedex.internetConection.dto

import com.jsrm.dogedex.Dog

class DogDTOMapper {

    private fun fromDogDTOToDogDomain(dogDTO: DogDTO): Dog {
        return Dog(dogDTO.id,
            dogDTO.type,
            dogDTO.heightMale,
            dogDTO.heightFemale,
            dogDTO.imgUrl,
            dogDTO.index,
            dogDTO.lifeExpectancy,
            dogDTO.name,
            dogDTO.temperament,
            dogDTO.weightFemale,
            dogDTO.weightMale)
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog> {
        return dogDTOList.map { fromDogDTOToDogDomain(it) }
    }
}