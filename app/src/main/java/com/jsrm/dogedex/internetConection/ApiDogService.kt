package com.jsrm.dogedex.internetConection

import com.jsrm.dogedex.BASE_URL
import com.jsrm.dogedex.GET_ALL_DOGS_URL
import com.jsrm.dogedex.SIGN_UP_URL
import com.jsrm.dogedex.internetConection.dto.SignUpDTO
import com.jsrm.dogedex.internetConection.responses.DogListApiResponse
import com.jsrm.dogedex.internetConection.responses.SignUpApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiDogService{
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse

    @POST(SIGN_UP_URL)
    suspend fun signUp(@Body signUpDTO: SignUpDTO): SignUpApiResponse
}

object DogsApi{
    val retrofitService: ApiDogService by lazy {
        retrofit.create(ApiDogService::class.java)
    }
}