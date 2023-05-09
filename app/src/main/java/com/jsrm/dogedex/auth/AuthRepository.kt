package com.jsrm.dogedex.auth

import com.jsrm.dogedex.model.User
import com.jsrm.dogedex.internetConection.DogsApi
import com.jsrm.dogedex.internetConection.ResponseStatus
import com.jsrm.dogedex.internetConection.dto.SignUpDTO
import com.jsrm.dogedex.internetConection.dto.UserDTOMapper
import com.jsrm.dogedex.internetConection.makeNetworkCall

class AuthRepository {
    suspend fun signUp(email: String, password: String, passwordConfirmation: String): ResponseStatus<User> = makeNetworkCall {
        val signUpDTO = SignUpDTO(email, password, passwordConfirmation)
        val signUpResponse = DogsApi.retrofitService.signUp(signUpDTO)

        if (signUpResponse.isSuccess){
            throw Exception(signUpResponse.message)
        }
        val userDTO = signUpResponse.data.user
        val userDTOMapper = UserDTOMapper()
        userDTOMapper.fromUserDTOToUserDomain(userDTO)
    }
}