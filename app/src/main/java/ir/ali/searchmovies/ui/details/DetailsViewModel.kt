package ir.ali.searchmovies.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import ir.ali.searchmovies.data.MovieRepository
import ir.ali.searchmovies.data.model.MovieDetails

class DetailsViewModel constructor(repo: MovieRepository) : ViewModel() {

    lateinit var API_KEY: String

    val movieIdObs: BehaviorSubject<Int> = BehaviorSubject.create()
    val movieDetailsObs: Observable<MovieDetails> = movieIdObs
        .observeOn(Schedulers.io())
        .switchMap { movieID ->
            repo.getMovieDetails(API_KEY, movieID)
                .doOnError { error ->
                    Log.e("DetailsError", error.toString())
                }
                .onErrorResumeNext(Observable.just(MovieDetails(-1, "Error", "0000")))
        }
}