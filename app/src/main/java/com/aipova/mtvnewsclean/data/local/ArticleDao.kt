package com.aipova.mtvnewsclean.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ArticleDao {
    @Insert
    fun insert(articles: List<ArticleEntity>)

    @Insert
    fun insert(vararg articles: ArticleEntity)

    @Query("DELETE FROM ${ArticleTable.NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${ArticleTable.NAME} ORDER BY ${ArticleTable.COLUMN_AUTHOR}")
    fun getAll(): List<ArticleEntity>
}