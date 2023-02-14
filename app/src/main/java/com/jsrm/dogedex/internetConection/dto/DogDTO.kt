package com.jsrm.dogedex.internetConection.dto

import com.squareup.moshi.Json

class DogDTO(
    val id: Long,
    @field:Json(name = "dog_type") val type: String,
    @field:Json(name = "height_female") val heightFemale: String,
    @field:Json(name = "height_male") val heightMale: String,
    @field:Json(name = "img_url") val imgUrl: String?,
    val index: Int,
    @field:Json(name = "life_expectancy") val lifeExpectancy: String,
    @field:Json(name = "name_en") val name: String,
    val temperament: String,
    @field:Json(name = "weight_female") val weightFemale: String,
    @field:Json(name = "weight_male") val weightMale: String,
)