package com.example.tractionassignment.util

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tractionassignment.Domain.Models.MovieResult
import com.example.tractionassignment.R
//import com.example.tractionassignment.databinding.MovieListCardBinding
import com.squareup.picasso.Picasso

// errors becasue of viewbindindg
//class MovieListAdapter(val c: Context, private val item: List<MovieResult>) :
class MovieListAdapter(val c: Context, val item: List<MovieResult>) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private val TAG = "MovieListAdapter"

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mImageView: ImageView = itemView.findViewById(R.id.movie_imageView)
        private val movieName: TextView = itemView.findViewById(R.id.movie_desc)
        private val movieReleaseDate: TextView = itemView.findViewById(R.id.movie_release_date)
        fun bind(p: MovieResult) {
            movieName.text = p.title
            movieReleaseDate.text = p.releaseDate
           // Picasso.get().load(R.drawable.ic_launcher_background).into(mImageView)

        }

    }



//    class MovieViewHolder(private val binding: MovieListCardBinding) : RecyclerView.ViewHolder(binding.root) {
//
//
//        fun bind(p: MovieResult) {
//            Log.e("MovieListAdapter", "onCreateView: onCreateViewHolder")
//            binding.apply {
//
//                movieDesc.text = p.originalTitle
//                movieReleaseDate.text = p.releaseDate
//                Picasso.get().load(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(movieImageView)
//                //Picasso.get().load(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(movieImageView)
//            }
//
//        }
//
//
//    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.movie_list_card,parent,false)
        return MovieViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        Log.e(TAG, "onCreateView:Onbiind problem")
        holder.bind(item[position])

    }

    override fun getItemCount(): Int {
        return item.size
    }


}