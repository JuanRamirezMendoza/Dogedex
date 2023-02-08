package com.jsrm.dogedex.internetConection

import com.jsrm.dogedex.BASE_URL
import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.GET_ALL_DOGS_URL
import com.jsrm.dogedex.internetConection.responses.DogListApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiDogService{
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse
}

object DogsApi{
    val retrofitService: ApiDogService by lazy {
        retrofit.create(ApiDogService::class.java)
    }
}