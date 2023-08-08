package com.example.tractionassignment.Viewmodels

import androidx.lifecycle.ViewModel
import com.example.tractionassignment.Repository.MovieListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.*
import com.example.tractionassignment.Domain.Models.MovieResult
import com.example.tractionassignment.Domain.Models.Movielistbaseresponse
import com.example.tractionassignment.Repository.MovRepository
import com.example.tractionassignment.Service.Movielistinterface
import com.example.tractionassignment.util.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response


@HiltViewModel
class MovielistViewModel@Inject constructor(val repository: MovieListRepository, val h: MovRepository):ViewModel() {

     private val movielistResponseM:MutableLiveData<Response<Movielistbaseresponse>> = MutableLiveData()
      val movielistResponse :LiveData<Response<Movielistbaseresponse>> = movielistResponseM

      val moviesObject = repository.getMovies().asLiveData()

//      fun postResponse(){
//            viewModelScope.launch {
//                  repository.getMovieListRequest().collect(){values ->
//                        movielistResponseM.value =values
//                  }
//            }
//
//      }

    fun pR(){
        viewModelScope.launch {
            h.getMovieListRequest().collect(){values ->
                movielistResponseM.value =values
            }
        }
    }




}