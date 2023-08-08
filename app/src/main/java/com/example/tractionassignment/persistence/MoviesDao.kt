package com.example.tractionassignment.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tractionassignment.Domain.Models.MovieResult
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao {

    @Query("SELECT * FROM Movies")
    fun getAllMovies(): Flow<List<MovieResult>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(items: List<MovieResult>)

    @Query("DELETE FROM Movies")
    suspend fun deleteAllMovies()

}