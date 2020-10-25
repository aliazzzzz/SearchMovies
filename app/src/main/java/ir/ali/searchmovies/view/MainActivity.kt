package ir.ali.searchmovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ali.searchmovies.R
import ir.ali.searchmovies.SearchMoviesApp
import ir.ali.searchmovies.data.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        val component = (applicationContext as SearchMoviesApp).appComponent
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MainViewModel by viewModels{viewModelFactory}
        viewModel.API_KEY = resources.getString(R.string.api_key)
        movie_recycler.layoutManager = LinearLayoutManager(this)
        movie_recycler.adapter = MovieListAdapter()

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