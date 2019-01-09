package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

object ApiFactory {
    val newsApi = createNewsApi(BuildConfig.API_ENDPOINT)

    fun createNewsApi(baseUrl: String): NewsApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createClient())
            .addConverterFactory(createGsonConverterFactory())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
    }

    private fun createGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setDateFormat(API_DATE_FORMAT).create())
    }


}