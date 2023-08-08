package com.example.tractionassignment.Service

import android.app.Application
import com.example.tractionassignment.persistence.MovieListDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    val First_url =
        "https://api.themoviedb.org/3/movie/"  //Link

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(g:Gson): GsonConverterFactory =
        GsonConverterFactory.create(g)


    @Singleton
    @Provides
    fun providesGSON(): Gson = GsonBuilder().create()


    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(First_url).client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun proviedMovieListNetworkRequest(r: Retrofit): Movielistinterface =
        r.create(Movielistinterface::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MovieListDatabase =
        Room.databaseBuilder(app, MovieListDatabase::class.java, "movielist_database").build()


}