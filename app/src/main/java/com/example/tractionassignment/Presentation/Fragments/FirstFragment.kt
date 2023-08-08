package com.example.tractionassignment.Presentation.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tractionassignment.Domain.Models.MovieResult
import com.example.tractionassignment.R
//import com.example.tractionassignment.Presentation.Activitiy.databinding.FragmentFirstBinding
import com.example.tractionassignment.Viewmodels.MovielistViewModel
//import com.example.tractionassignment.databinding.FragmentFirstBinding
import com.example.tractionassignment.util.MovieListAdapter
import com.example.tractionassignment.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val TAG = "FirstFragment"
    private val firstFragmentViewModel: MovielistViewModel by viewModels()
    private lateinit var movieItems: List<MovieResult>
    private lateinit var rvAdapter: MovieListAdapter
    private lateinit var movielistRecyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager


    // private var _binding: FragmentFirstBinding? = null

//     This property is only valid between onCreateView and
//     onDestroyView.
//    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //   _binding = FragmentFirstBinding.inflate(inflater, container, false)

//            return binding.root
        val v = inflater.inflate(R.layout.fragment_first, container, false)

        movielistRecyclerView = v.findViewById(R.id.popular_movie_list)
        linearLayoutManager = LinearLayoutManager(requireContext())
        movielistRecyclerView.layoutManager = linearLayoutManager
        movielistRecyclerView.setHasFixedSize(true)
       // loadItems()
        loadIthems()

        return v
    }

    private fun loadIthems() {
          firstFragmentViewModel.pR()
        firstFragmentViewModel.movielistResponse.observe(viewLifecycleOwner){res ->
            Log.e(TAG, "onCreateView: AnotherENtryPoint1 ${res.code()}")
           // Toast.makeText(requireContext(), "There is an Error${res.code()}", Toast.LENGTH_LONG).show()



            if(res.isSuccessful){
               movieItems = res.body()!!.results
                Log.e(TAG, "onCreateView: ENtryPoint2  ${res.code()} ${movieItems.size} ${movieItems.get(3)}")
                rvAdapter = MovieListAdapter(requireContext(),movieItems)
                movielistRecyclerView.adapter = rvAdapter
            }else{
                Toast.makeText(requireContext(), "There is an Error", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "onCreateView: Error ${res.code()}")
            }
          }


    }


    private fun loadItems() {
        firstFragmentViewModel.moviesObject.observe(viewLifecycleOwner) { result ->
            Log.e(TAG, "onCreateView: ENtryPoint1")

            when (result) {

                is Resource.Success -> {
                    result.data?.let {
                        movieItems = result.data
                        Log.e(TAG, "onCreateView: ENtryPoint2  ${movieItems.size}")

                        rvAdapter = result.data.let { MovieListAdapter(requireContext(), it) }!!
                        movielistRecyclerView.adapter = rvAdapter

                    }
                }

                is Resource.Error -> {
                    Toast.makeText(requireContext(), "There is an Error", Toast.LENGTH_SHORT).show()
                    Log.e(TAG, "onCreateView: Error ${result.error?.localizedMessage}")
                }

                is Resource.Loading -> {


                }


            }


            // movieItems = result.data //loading data


//            rvAdapter = result.data?.let { MovieListAdapter(requireContext(), it) }!!
//            movielistRecyclerView.adapter = rvAdapter


        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // _binding = null
    }
}

