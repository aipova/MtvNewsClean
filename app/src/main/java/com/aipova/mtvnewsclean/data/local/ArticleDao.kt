package com.aipova.mtvnewsclean.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aipova.mtvnewsclean.data.model.Article


@Dao
interface ArticleDao {
    @Insert
    fun insert(articles: List<Article>)

    @Insert
    fun insert(vararg articles: Article)

    @Query("DELETE FROM ${ArticleTable.NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${ArticleTable.NAME} ORDER BY ${ArticleTable.COLUMN_AUTHOR}")
    fun getAll(): List<Article>
}