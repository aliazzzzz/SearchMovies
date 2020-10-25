package ir.ali.searchmovies.view

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import ir.ali.searchmovies.data.model.Movie
import javax.inject.Inject


class MainViewModel @Inject constructor() : ViewModel() {

    val movieListObs: Observable<List<Movie>> = Observable.just(arrayListOf(Movie("Movie 1", 1990), Movie("Movie 2", 2003), Movie("Movie 3", 2014)))
}