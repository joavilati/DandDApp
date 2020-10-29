package com.example.danddapp.di

import com.example.danddapp.repository.DnD5ThRepository
import com.example.danddapp.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

// DI - Data Injection

@Module // Informing that it is a module
@InstallIn(ApplicationComponent::class) // The inside components are linked to the lifecycle of application
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindDnDRepository(
        dnD5ThRepository: DnD5ThRepository
    ): Repository
}