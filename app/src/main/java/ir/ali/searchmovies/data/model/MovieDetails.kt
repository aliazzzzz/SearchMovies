package ir.ali.searchmovies.data.model

data class MovieDetails(
    val id: Int,
    val title: String,
    val year: String,
    val poster: String = "",
    val overview: String = "",
    val genres: String = ""
)