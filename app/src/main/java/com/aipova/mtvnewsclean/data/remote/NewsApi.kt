package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface NewsApi {
    @GET(TOP_HEADLINES)
    fun getTopHeadlines(@Query("country") country: String = "ru"): Observable<NewsResponse>

    companion object {
        const val TOP_HEADLINES = "/v2/top-headlines"
    }
}
