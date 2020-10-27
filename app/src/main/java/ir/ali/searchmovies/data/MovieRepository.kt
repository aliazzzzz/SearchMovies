package ir.ali.searchmovies.data

import io.reactivex.Observable
import ir.ali.searchmovies.data.mapper.MovieMapper
import ir.ali.searchmovies.data.model.Movie
import ir.ali.searchmovies.data.model.MovieDetails


class MovieRepository constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper
) {

    fun getMovieList(apiKey: String, query: String): Observable<List<Movie>> {
        return apiService
            .searchMovie(apiKey, query)
            .map {
                mapper.toMovieList(it)
            }
    }

    fun getMovieDetails(apiKey: String, movieID: Int): Observable<MovieDetails> {
        return apiService
            .getDetails(movieID, apiKey)
            .map {
                mapper.toMovieDetails(it)
            }
    }
}