package com.example.danddapp.repository

import com.example.danddapp.models.DnDClass
import com.example.danddapp.models.index.Index
import com.example.danddapp.remote.util.LiveDataResult

interface Repository {
    suspend fun getClasses(listener: (LiveDataResult<List<Index>>) -> Unit)
    suspend fun getDnDClass(classIndex: String, listener: (LiveDataResult<DnDClass>) -> Unit)
}