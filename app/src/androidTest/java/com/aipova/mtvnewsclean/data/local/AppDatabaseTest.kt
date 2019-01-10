package com.aipova.mtvnewsclean.data.local

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var db: AppDatabase
    private lateinit var articleDao: ArticleDao

    @Before
    fun setUp() {
        db = AppDatabase.buildInMemoryDatabase(InstrumentationRegistry.getInstrumentation().targetContext)
        articleDao = db.getArticleDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun shouldInsertArticle() {
        val article = ArticleEntity(content = "content",  title = "title")
        articleDao.insert(article)
        val list = articleDao.getAll()
        assertEquals("Should insert article", 1, list.size)
        assertEquals("Should insert article data", article.content, list.first().content)
    }

    @Test
    fun shouldIncrementArticleId() {
        val article1 = ArticleEntity(content = "content1", title = "title1")
        val article2 = ArticleEntity(content = "content2", title = "title2")
        articleDao.insert(article1, article2)
        val list = articleDao.getAll()

        assertEquals("Should insert two articles", 2, list.size)
        assertNotEquals("Article's ID'' must be incremented", list[0].id, list[1].id)
    }

    @Test
    fun shouldDeleteALlArticles() {
        val article1 = ArticleEntity(content = "content1", title = "title1")
        val article2 = ArticleEntity(content = "content2", title = "title2")
        articleDao.insert(article1, article2)
        var list = articleDao.getAll()
        assertTrue("Articles table shouldn't be empty", list.isNotEmpty())

        articleDao.deleteAll()
        list = articleDao.getAll()
        assertTrue("Articles table shouldn be empty", list.isEmpty())
    }
}