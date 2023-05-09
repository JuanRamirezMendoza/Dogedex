package com.jsrm.dogedex.internetConection.dto

import com.jsrm.dogedex.model.User

class UserDTOMapper {

    fun fromUserDTOToUserDomain(userDTO: UserDTO) =
        User(userDTO.id, userDTO.email, userDTO.authenticationToken)

}