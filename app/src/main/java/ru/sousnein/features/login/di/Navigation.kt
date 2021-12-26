package ru.sousnein.features.login.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sousnein.features.login.navigation.ILoginNavigation
import ru.sousnein.features.login.navigation.LoginNavigationImpl

@Module
@InstallIn(SingletonComponent::class)
interface Navigation {

    @Binds
    fun loginNavigation(navigator: LoginNavigationImpl): ILoginNavigation

}