package ir.ali.searchmovies.data.model

import com.google.gson.annotations.SerializedName

data class SearchMovieDataModel (
    @SerializedName("results")
    val results: List<Result>
)

data class Result(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String?
)