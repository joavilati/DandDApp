package com.example.danddapp.remote.util

import retrofit2.Response

object LiveDataNetworking {
    fun <T> request(response: Response<T>): LiveDataResult<T> {
        return try {

            val body = response.body()

            if (response.isSuccessful && body != null) {
                LiveDataResult.success(body)
            } else {
                //TODO create exception
                LiveDataResult.error(Exception("Deu ruim bruxo"), response.code())
            }
        } catch (e: Exception) {
            LiveDataResult.error(e, response.code())
        }
    }

    fun <T> requestWithoutResponse(response: Response<T>): LiveDataResult<Void?> {
        return try {
            if (response.isSuccessful) {
                LiveDataResult.success(null)
            } else {
                //TODO create exception
                LiveDataResult.error(Exception("Deu ruim bruxo"))
            }
        } catch (e: Exception) {
            LiveDataResult.error(e)
        }
    }
}