package ir.ali.searchmovies.data.mapper

import ir.ali.searchmovies.data.model.Movie
import ir.ali.searchmovies.data.model.MovieDetails
import ir.ali.searchmovies.data.model.MovieDetailsDataModel
import ir.ali.searchmovies.data.model.SearchMovieDataModel
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun toMovieList(serverModel: SearchMovieDataModel): List<Movie> {

        return serverModel.results.map {
            Movie(
                it.id,
                it.title,
                mapDateToYear(it.releaseDate)
            )
        }
    }

    fun toMovieDetails(serverModel: MovieDetailsDataModel) : MovieDetails {
        return MovieDetails(
            serverModel.id,
            serverModel.title,
            mapDateToYear(serverModel.releaseDate),
            serverModel.posterPath ?: "",
            serverModel.overview ?: "",
            serverModel.genreList.joinToString(", ") {
                it.name
            }
        )
    }

    private fun mapDateToYear(date: String?) : String {
        return if (date != null) {
            if (date.length > 4)
                date.substring(0, 4)
            else
                date
        }
            else
                ""

        //it.releaseDate?.substring(0,4)?: "")
    }

}
