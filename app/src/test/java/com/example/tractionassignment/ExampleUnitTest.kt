package com.example.tractionassignment

//import com.squareup.picasso.BuildConfig

import com.example.tractionassignment.Service.NetworkModule
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testRetrofitInstance() {
        //Get an instance of Retrofit
        val okHttpClient:OkHttpClient =
            OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
        val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()
        val instance: Retrofit = NetworkModule().provideRetrofit(okHttpClient,gsonConverterFactory)
        //Assert that, Retrofit's base url matches to our BASE_URL
        assert(instance.baseUrl().url().toString() == NetworkModule().First_url)
    }




}