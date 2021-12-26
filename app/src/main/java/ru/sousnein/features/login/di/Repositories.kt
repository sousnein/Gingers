package ru.sousnein.features.login.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sousnein.features.login.data.AuthRepositoryImpl
import ru.sousnein.features.login.data.IAuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface Repositories {

    @Binds
    @Singleton
    fun authRepository(impl: AuthRepositoryImpl): IAuthRepository

}