package com.jsrm.dogedex

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imgUrl: String?,
    val index: Int,
    val lifeExpectancy: String,
    val name: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String,
) : Parcelable