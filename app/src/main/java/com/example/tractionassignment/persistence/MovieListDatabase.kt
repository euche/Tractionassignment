package com.example.tractionassignment.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tractionassignment.Domain.Models.MovieResult
import com.example.tractionassignment.util.Genreidconverter

// error gotten as a result of the compiler mistakening Result class for Kotlin .Result

@TypeConverters(Genreidconverter::class)
@Database(entities =[MovieResult::class],version = 1 )
abstract class MovieListDatabase:RoomDatabase() {
    abstract fun MovieListDao(): MoviesDao
}