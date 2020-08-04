package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.movie.Movie
import com.example.fragments.R

class MoviesAdapter(private val movies: List<Movie>, var clickListener: onMovieItemClickListener) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitleView = itemView.findViewById<TextView>(R.id.movieItem)
        fun init(item: Movie, action: onMovieItemClickListener) {
            movieTitleView.text = item.title
            itemView.setOnClickListener() {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val movieItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(movieItemView)
    }

    override fun onBindViewHolder(viewholder: MoviesAdapter.ViewHolder, position: Int) {
        viewholder.init(movies.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

interface onMovieItemClickListener {
    fun onItemClick(item: Movie, position: Int)
}
