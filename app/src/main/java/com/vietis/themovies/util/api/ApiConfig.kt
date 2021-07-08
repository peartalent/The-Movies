package com.vietis.themovies.util.api

object ApiConfig {
    private const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "api_key"

    fun getUrlImage(url: String?) = BASE_URL_IMAGE + url
}