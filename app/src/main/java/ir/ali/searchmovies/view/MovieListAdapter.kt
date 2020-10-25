package ir.ali.searchmovies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.ali.searchmovies.R
import ir.ali.searchmovies.data.model.Movie

class MovieListAdapter : ListAdapter<Movie, MovieViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var titleTV: TextView? = null
    private var yearTV: TextView? = null


    init {
        titleTV = itemView.findViewById(R.id.list_title)
        yearTV = itemView.findViewById(R.id.list_description)
    }

    fun bind(movie: Movie) {
        titleTV?.text = movie.title
        yearTV?.text = movie.year
    }

}