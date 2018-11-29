package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("X-Api-Key", BuildConfig.API_KEY).build()
        return chain.proceed(request)
    }

}
