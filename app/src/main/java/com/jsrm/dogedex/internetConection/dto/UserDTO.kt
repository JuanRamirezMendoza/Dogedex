package com.jsrm.dogedex.internetConection.dto

import com.jsrm.dogedex.internetConection.responses.DogListResponse
import com.squareup.moshi.Json

class UserDTO(
    val id: Long,
    val email: String,
    @field:Json(name = "authentication_token") val authenticationToken: String
)
