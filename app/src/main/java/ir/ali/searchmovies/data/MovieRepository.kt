package ir.ali.searchmovies.data

import io.reactivex.Observable
import ir.ali.searchmovies.data.mapper.SearchMovieMapper
import ir.ali.searchmovies.data.model.Movie


class MovieRepository constructor(
    private val apiService: ApiService,
    private val mapper: SearchMovieMapper
) {

    fun getMovieList(apiKey: String, query: String): Observable<List<Movie>> {
        return apiService
            .searchMovie(apiKey, query)
            .map {
                mapper.toMovieList(it)
            }
    }
}