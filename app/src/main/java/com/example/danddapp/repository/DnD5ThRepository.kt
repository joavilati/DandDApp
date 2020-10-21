package com.example.danddapp.repository

import com.example.danddapp.models.DnDClass
import com.example.danddapp.models.index.Index
import com.example.danddapp.remote.util.Controller
import com.example.danddapp.remote.util.LiveDataNetworking
import com.example.danddapp.remote.util.LiveDataResult
import com.example.danddapp.retrofit.DnDService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.create
import java.lang.Exception

class DnD5ThRepository {

    var service = Controller.retrofit.create(DnDService::class.java)

    suspend fun getClasses(listener: (LiveDataResult<List<Index>>) -> Unit) {
        withContext(IO) {
            try {
                val request = service.getClasses()
                val response = LiveDataNetworking.request(request)
                listener(response)
            } catch (e: Exception) {
                listener(LiveDataResult.error(e))
            }
        }
    }

    suspend fun getDnDClass(classIndex: String, listener: (LiveDataResult<DnDClass>) -> Unit) {
        withContext(IO) {
            try {
                val request = service.getDnDClass(classIndex)
                val response = LiveDataNetworking.request(request)
                listener(response)
            } catch (e: Exception) {
                listener(LiveDataResult.error(e))
            }
        }
    }
}