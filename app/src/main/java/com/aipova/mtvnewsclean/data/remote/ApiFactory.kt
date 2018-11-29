package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    val newsApi = Retrofit.Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(NewsApi::class.java)
}