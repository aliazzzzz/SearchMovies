package ir.ali.searchmovies.data

import dagger.Lazy
import io.reactivex.Observable
import ir.ali.searchmovies.data.mapper.SearchMovieMapper
import ir.ali.searchmovies.data.model.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Lazy<SearchMovieMapper>
) {

    fun getMovieList(apiKey: String, query: String): Observable<List<Movie>> {
        return apiService
            .searchMovie(apiKey, query)
            .map {
                mapper.get().toMovieList(it)
            }
    }
}