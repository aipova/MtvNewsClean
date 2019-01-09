package com.aipova.mtvnewsclean.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.aipova.mtvnewsclean.data.local.ArticleTable
import java.util.*

@Entity(tableName = ArticleTable.NAME)
data class Article(
    @ColumnInfo(name = ArticleTable.COLUMN_AUTHOR)
    val author: String?,

    @ColumnInfo(name = ArticleTable.COLUMN_CONTENT)
    val content: String,

    @ColumnInfo(name = ArticleTable.COLUMN_DESCRIPTION)
    val description: String?,

    @ColumnInfo(name = ArticleTable.COLUMN_PUBLISHED_AT)
    val publishedAt: Date,

    @Ignore
    val source: Source,

    @ColumnInfo(name = ArticleTable.COLUMN_TITLE)
    val title: String,

    @ColumnInfo(name = ArticleTable.COLUMN_URL)
    val url: String,

    @ColumnInfo(name = ArticleTable.COLUMN_URL_TO_IMAGE)
    val urlToImage: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ArticleTable.COLUMN_ID)
    var id: Int = 0
}