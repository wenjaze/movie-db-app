package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.Movie
import com.example.fragments.R

class MoviesAdapter (private val Movies: List<Movie>,var clickListener: onMovieItemClickListener) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val movieTitleView = itemView.findViewById<TextView>(R.id.movie_title)
        fun init(item:Movie,action:onMovieItemClickListener) {
            movieTitleView.text = item.title
            itemView.setOnClickListener(){
                action.onItemClick(item,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieItemView = inflater.inflate(R.layout.item_movie,parent,false)
        return ViewHolder(movieItemView)
    }

    override fun onBindViewHolder(viewholder: MoviesAdapter.ViewHolder, position: Int) {
        // val movies:Movie = Movies.get(position)
        // val textView = viewholder.movieTitleView
        // textView.setText(movies.title)
        viewholder.init(Movies.get(position),clickListener)
    }

    override fun getItemCount(): Int {
        return Movies.size
    }


}

interface onMovieItemClickListener {
    fun onItemClick(item:Movie,position: Int)
}
