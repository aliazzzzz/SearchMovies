package ir.ali.searchmovies.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsDataModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("genres")
    val genreList: List<Genre>
)

data class Genre (
    @SerializedName("name")
    val name: String
)
