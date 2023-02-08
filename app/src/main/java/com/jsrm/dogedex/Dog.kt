package com.jsrm.dogedex

data class Dog(
    val id: Long, val index: Int, val type: String, val name: String,
    val heightFemale: Double, val heightMale: Double, val imgUrl: String,
    val lifeExpectancy: String, val temperament: String, val weightFemale: Double,
    val weightMale: Double,
) {
}