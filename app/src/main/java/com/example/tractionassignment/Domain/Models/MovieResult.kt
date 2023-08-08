package com.example.tractionassignment.Domain.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Movies")
data class MovieResult(    //@SerializedName("adult")
    val adult: Boolean,

    val backdropPath: String,

    val genreIds: List<Int>,

    @PrimaryKey
    val id: Int,       // primary key

    val originalLanguage: String,

    val originalTitle: String,

    val overview: String,

    val popularity: Double,

    val posterPath: String,

    val releaseDate: String,

    val title: String,

    val video: Boolean,

    val voteAverage: Double,

    val voteCount: Int)
