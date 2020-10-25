package ir.ali.searchmovies.view

import androidx.recyclerview.widget.DiffUtil
import ir.ali.searchmovies.data.model.Movie

class DiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}