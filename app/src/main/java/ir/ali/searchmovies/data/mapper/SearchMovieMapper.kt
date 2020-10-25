package ir.ali.searchmovies.data.mapper

import ir.ali.searchmovies.data.model.Movie
import ir.ali.searchmovies.data.model.SearchMovieDataModel
import javax.inject.Inject

class SearchMovieMapper @Inject constructor() {

    fun toMovieList(serverModel: SearchMovieDataModel): List<Movie> {

        return serverModel.results.map {
            Movie(
                it.title,
                if (it.releaseDate != null)
                    if (it.releaseDate.length > 4)
                        it.releaseDate.substring(0, 4)
                    else
                        it.releaseDate
                else
                    "")

                //it.releaseDate?.substring(0,4)?: "")
        }
    }

}
