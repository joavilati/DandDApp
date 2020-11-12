package com.example.danddapp.models

import java.io.Serializable

data class DnDClass(
    val index: String,
    val name: String,
    val proficiencyChoices: List<Proficiency>
): Serializable