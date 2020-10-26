package ir.ali.searchmovies.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.ali.searchmovies.R
import ir.ali.searchmovies.data.model.Movie

class MovieListAdapter(private val listener: OnItemClickListener) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(
    DiffCallback()
) {

    interface OnItemClickListener {
        fun onItemClick(item: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(view: View) :RecyclerView.ViewHolder(view) {

        private val titleTV: TextView? = view.findViewById(R.id.list_title)
        private val yearTV: TextView? = view.findViewById(R.id.list_description)

        fun bind(movie: Movie) {
            titleTV?.text = movie.title
            yearTV?.text = movie.year
            itemView.setOnClickListener {
                listener.onItemClick(movie)
            }
        }

    }

}