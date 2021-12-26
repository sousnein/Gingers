package ru.sousnein.features.login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bitreader.androidclient.navigation.AppNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    @LoginNavigator
    fun provideLoginNavigator(): AppNavigator = AppNavigator()

}