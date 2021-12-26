package ru.sousnein.navigation.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.sousnein.features.login.di.LoginNavigator
import ru.sousnein.navigation.AppNavigator
import javax.inject.Singleton

@EntryPoint
@InstallIn(ActivityComponent::class)
interface LocalNavigatorProvider {

/*   @LibraryNavigator
    @Singleton
    fun libraryNavigator(): AppNavigator

    @ProfileNavigator
    @Singleton
    fun profileNavigator(): AppNavigator*/

    @LoginNavigator
    @Singleton
    fun loginNavigator(): AppNavigator

}