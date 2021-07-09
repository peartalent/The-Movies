package com.vietis.themovies.util.api

import com.vietis.themovies.BuildConfig

object ApiConfig {
    private const val BASE_URL_IMAGE = BuildConfig.BASE_URL_IMAGE
    const val BASE_URL = BuildConfig.BASE_URL
    const val API_KEY = "api_key"

    fun getUrlImage(url: String?) = BASE_URL_IMAGE + url
}