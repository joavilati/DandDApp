package com.example.danddapp.retrofit

import com.example.danddapp.models.DnDClass
import com.example.danddapp.models.index.Index
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DnDService{

    @GET("classes/")
    suspend fun getClasses(): Response<List<Index>>

    @GET("classes/{classIndex}")
    suspend fun getDnDClass(
        @Path("classIndex") classIndex: String
    ): Response<DnDClass>

}