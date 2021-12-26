package ru.sousnein.core.network.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://apidev.bitreader.ru/graphql"

    @Provides
    fun provideApolloClient(): ApolloClient {
        val okHttp = OkHttpClient
            .Builder()
            .build()

        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttp)
            .build()
    }

}