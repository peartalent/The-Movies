package com.vietis.themovies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vietis.themovies.data.DiffEntity
import com.vietis.themovies.util.GenreUtil

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    val movieId: Int,
    var title: String,
    var genre: String,
    var rate: Float,
    var description: String,
    var company: String,
    var companyLogo: String?,
    var poster: String,
    var background: String,
    var releaseDate: String
) : DiffEntity {

    override fun areItemsTheSame(newItem: DiffEntity): Boolean =
        newItem is Movie && this.movieId == newItem.movieId

    override fun areContentsTheSame(newItem: DiffEntity): Boolean =
        newItem is Movie && this == newItem

    @Throws(IllegalArgumentException::class)
    constructor(movieResponse: MovieResponse) : this(
        movieResponse.id,
        movieResponse.title,
        GenreUtil.getNameGenre(movieResponse.getGenreDefaultId()),
        movieResponse.rate,
        movieResponse.description,
        movieResponse.getCompanyPopular()[0].name,
        movieResponse.getCompanyPopular()[0].logo,
        movieResponse.poster,
        movieResponse.background,
        movieResponse.releaseDate
    )
}
