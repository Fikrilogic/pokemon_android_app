package com.fikrisandi.remote.di

import android.content.Context
import com.fikrisandi.framework.network.createRetrofit
import com.fikrisandi.framework.network.interceptor.HttpRequestInterceptor
import com.fikrisandi.remote.BuildConfig
import com.fikrisandi.remote.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


private const val BASE_URL = "base_url"

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun provideBaseUrl() = BuildConfig.URL_NAME

    @Provides
    @Singleton
    fun provideOkHttpRequestInterceptor() = HttpRequestInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpRequestInterceptor: HttpRequestInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(httpRequestInterceptor)
            connectTimeout(60L, TimeUnit.SECONDS)
            readTimeout(60L, TimeUnit.SECONDS)
            writeTimeout(60L, TimeUnit.SECONDS)
            followSslRedirects(true)
            followRedirects(true)
            retryOnConnectionFailure(true)
        }.build()
    }

    @Provides
    @Singleton
    fun providePokemonService(
        @Named(value = BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient
    ): PokemonService {
        return createRetrofit(okHttpClient, baseUrl)
    }

}