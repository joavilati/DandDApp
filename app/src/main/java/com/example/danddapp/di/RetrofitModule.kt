package com.example.danddapp.di

import com.example.danddapp.remote.util.SupportInterceptor
import com.example.danddapp.remote.util.baseUrl
import com.example.danddapp.retrofit.DnDapi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideDnDService(): DnDapi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(SupportInterceptor())

        val retrofit = Retrofit.Builder().client(builder.build()).baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(DnDapi::class.java)
    }
}