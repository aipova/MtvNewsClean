package com.aipova.mtvnewsclean.data.remote

import com.aipova.mtvnewsclean.data.model.NewsResponse
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.File

class NewsApiTest {
    private var mockServer = MockWebServer()
    private lateinit var newsApi: NewsApi

    @Before
    fun setUp() {
        mockServer.start()
        newsApi = ApiFactory.createNewsApi(mockServer.url("/").toString())
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun shouldAddApiKeyRequestHeader() {
        val mockHeadlinesResponse = MockResponse().setResponseCode(200).setBody("{}")
        mockServer.enqueue(mockHeadlinesResponse)

        newsApi.getTopHeadlines().toBlocking().single()

        val request = mockServer.takeRequest()
        assertNotNull(request.getHeader("X-Api-Key"))
    }

    @Test
    fun shouldConvertResponseToJson() {
        val jsonResponse = getJson("json/top_headlines.json")
        val mockHeadlinesResponse = MockResponse().setResponseCode(200).setBody(jsonResponse)
        mockServer.enqueue(mockHeadlinesResponse)

        val response = newsApi.getTopHeadlines().toBlocking().single()
        val expectedResponse = GsonBuilder().setDateFormat(API_DATE_FORMAT).create().fromJson(jsonResponse, NewsResponse::class.java)

        assertEquals(expectedResponse, response)
    }

    private fun getJson(path: String): String {
        return javaClass.classLoader?.getResource(path)?.let { url ->
            String(File(url.path).readBytes())
        } ?: JsonObject().asString
    }
}