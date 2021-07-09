package com.vietis.themovies.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vietis.themovies.data.model.Actor
import com.vietis.themovies.data.model.Movie
import com.vietis.themovies.data.source.DatabaseConfig
import com.vietis.themovies.data.source.local.dao.ActorDao
import com.vietis.themovies.data.source.local.dao.MovieDao

@Database(
    entities = [Movie::class, Actor::class],
    version = DatabaseConfig.DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
}