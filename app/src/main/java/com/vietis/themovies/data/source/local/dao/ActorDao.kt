package com.vietis.themovies.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.vietis.themovies.data.model.Actor

@Dao
interface ActorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertActors(actors: List<Actor>)
}