package com.example.tractionassignment.Repository

import com.example.tractionassignment.Domain.Models.Movielistbaseresponse
import com.example.tractionassignment.Service.Movielistinterface
import com.example.tractionassignment.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MovRepository @Inject constructor(private val datasource: Movielistinterface) {

    suspend fun getMovieListRequest(): Flow<Response<Movielistbaseresponse>> {

//        return flow {
//            emit(apiCall.fetchMovies())
//        }.flowOn(Dispatchers.IO)

        return flow{
            emit(datasource.fetchMovies())
        }.flowOn(Dispatchers.IO)

    }





}