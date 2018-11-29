package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.data.model.Article
import rx.Observable

class NewsRemoteDataSource(private val newsApi: NewsApi) {
    fun getTopHeadlines(): Observable<List<Article>> {
        return newsApi.getTopHeadlines().map { it.articles }
    }
}