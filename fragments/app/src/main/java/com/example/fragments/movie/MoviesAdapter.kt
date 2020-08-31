package com.example.fragments.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R

class MoviesAdapter(private var movies: List<Movie>, var clickListener: OnMovieItemClickListener) :
	RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val movieItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
		return ViewHolder(movieItemView)
	}

	override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
		viewholder.init(movies[position], clickListener)
	}

	override fun getItemCount(): Int = movies.size

	interface OnMovieItemClickListener {
		fun onItemClick(item: Movie, position: Int)
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val movieTitleView = itemView.findViewById<TextView>(R.id.movieItem)
		fun init(item: Movie, action: OnMovieItemClickListener) {
			movieTitleView.text = item.title
			itemView.setOnClickListener() {
				action.onItemClick(item, adapterPosition)
			}
		}
	}

	fun clearAdapter() {
		movies = emptyList()
		notifyDataSetChanged()
	}

	fun setMovies(mvs: List<Movie>) {
		movies = mvs
		notifyDataSetChanged()
	}
}
