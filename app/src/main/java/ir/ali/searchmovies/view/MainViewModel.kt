package ir.ali.searchmovies.view

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import ir.ali.searchmovies.data.MovieRepository
import ir.ali.searchmovies.data.model.Movie
import javax.inject.Inject


class MainViewModel @Inject constructor(repo: MovieRepository) : ViewModel() {

    lateinit var API_KEY: String

    val queryObs: BehaviorSubject<String> = BehaviorSubject.create()
    val movieListObs: Observable<List<Movie>> = queryObs
        .observeOn(Schedulers.io())
        .switchMap { query ->
            repo.getMovieList(API_KEY, query)
                .doOnError { error ->
                    Log.e("SearchError", error.toString())
                }
                .onErrorResumeNext(Observable.just(arrayListOf(Movie("Error", "0000"))))
        }
}