package com.example.tractionassignment.Repository

import androidx.room.withTransaction
import com.example.tractionassignment.Domain.Models.MovieResult
import com.example.tractionassignment.Domain.Models.Movielistbaseresponse
import com.example.tractionassignment.Service.Movielistinterface
import com.example.tractionassignment.persistence.MovieListDatabase
import com.example.tractionassignment.util.Resource
import javax.inject.Inject
import kotlinx.coroutines.delay
import com.example.tractionassignment.util.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MovieListRepository @Inject constructor(
    private val apiCall: Movielistinterface,
    private val db: MovieListDatabase,
) {

    private lateinit var mList: List<MovieResult>
    private val moviesDao = db.MovieListDao()

     fun getMovies() = networkBoundResource(

        query = {
            moviesDao.getAllMovies()

        },
   fetch = {
           delay(2000)
          transformResultS(apiCall.fetchMovies())
   },
        saveFetchResult = { obj: List<MovieResult> ->
            db.withTransaction {
                moviesDao.deleteAllMovies()
                moviesDao.insertMovies(obj)
            }

        }
    )

    private fun transformResultS(k: Response<Movielistbaseresponse>): List<MovieResult>{
       return k.body()!!.results
    }





}

