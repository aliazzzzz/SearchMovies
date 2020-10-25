package ir.ali.searchmovies.data

import io.reactivex.Observable
import ir.ali.searchmovies.data.model.SearchMovieDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/movie")
    fun searchMovie(
        @Query("api_key")
        key: String,
        @Query("query")
        query: String
    ): Observable<SearchMovieDataModel>

}
