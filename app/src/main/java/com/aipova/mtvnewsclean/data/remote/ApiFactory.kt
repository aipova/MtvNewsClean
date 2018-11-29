package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    val newsApi = createNewsApi(BuildConfig.API_ENDPOINT)

    fun createNewsApi(baseUrl: String): NewsApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
    }


}