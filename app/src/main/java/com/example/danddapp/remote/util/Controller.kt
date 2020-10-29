package com.example.danddapp.remote.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val baseUrl = "https://www.dnd5eapi.co/api/"

class Controller : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept","application/json")
            ?.build()
        return  chain.proceed(request)
    }

}