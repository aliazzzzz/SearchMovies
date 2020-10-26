package ir.ali.searchmovies.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ali.searchmovies.R
import ir.ali.searchmovies.data.model.Movie
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class SearchFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : SearchViewModel by viewModels{viewModelFactory}
        viewModel.API_KEY = resources.getString(R.string.api_key)

        movie_recycler.layoutManager = LinearLayoutManager(context)
        movie_recycler.adapter = MovieListAdapter(
            object : MovieListAdapter.OnItemClickListener {
                override fun onItemClick(item: Movie) {
                    findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
                }
            })

        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.queryObs.onNext(query)

                return false
            }

        })

        viewModel
            .movieListObs
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { refreshList(it) }

    }

    private fun refreshList(movies: List<Movie>) {
        (movie_recycler.adapter as MovieListAdapter).submitList(movies)
    }

}