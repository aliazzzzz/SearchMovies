package ir.ali.searchmovies.data

import dagger.Lazy
import io.reactivex.Observable
import ir.ali.searchmovies.data.mapper.MovieMapper
import ir.ali.searchmovies.data.model.Movie
import ir.ali.searchmovies.data.model.MovieDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Lazy<MovieMapper>
) {

    fun getMovieList(apiKey: String, query: String): Observable<List<Movie>> {
        return apiService
            .searchMovie(apiKey, query)
            .map {
                mapper.get().toMovieList(it)
            }
    }

    fun getMovieDetails(apiKey: String, movieID: Int): Observable<MovieDetails> {
        return apiService
            .getDetails(movieID, apiKey)
            .map {
                mapper.get().toMovieDetails(it)
            }
    }
}