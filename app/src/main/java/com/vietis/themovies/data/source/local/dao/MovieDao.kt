package com.vietis.themovies.data.source.local.dao

import androidx.room.*
import com.vietis.themovies.data.model.Actor
import com.vietis.themovies.data.model.Movie
import com.vietis.themovies.data.model.MovieWithActors

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movie: Movie)

    @Query("select * from movie")
    fun getMovieWithActors(): List<MovieWithActors>

    @Query("Select exists(select * from movie where movieId=:movieId)")
    fun isFavorite(movieId: Int): Boolean

    @Delete
    fun delete(movie: Movie, actor: List<Actor>)
}