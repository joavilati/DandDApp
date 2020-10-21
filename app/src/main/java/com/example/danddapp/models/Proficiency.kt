package com.example.danddapp.models

import com.example.danddapp.models.index.Index
import java.io.Serializable

data class Proficiency(
    val choose: Int,
    val type: String,
    val from: List<Index>
): Serializable