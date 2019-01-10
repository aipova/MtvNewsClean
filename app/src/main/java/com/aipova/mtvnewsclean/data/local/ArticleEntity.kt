package com.aipova.mtvnewsclean.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ArticleTable.NAME)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ArticleTable.COLUMN_ID)
    var id: Long = 0,
    @ColumnInfo(name = ArticleTable.COLUMN_AUTHOR)
    val author: String = "",

    @ColumnInfo(name = ArticleTable.COLUMN_CONTENT)
    val content: String = "",

    @ColumnInfo(name = ArticleTable.COLUMN_DESCRIPTION)
    val description: String = "",

    @ColumnInfo(name = ArticleTable.COLUMN_TITLE)
    val title: String = "",

    @ColumnInfo(name = ArticleTable.COLUMN_URL)
    val url: String = "",

    @ColumnInfo(name = ArticleTable.COLUMN_URL_TO_IMAGE)
    val urlToImage: String = ""

)