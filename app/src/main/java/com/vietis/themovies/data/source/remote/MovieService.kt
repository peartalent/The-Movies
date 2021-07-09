package com.vietis.themovies.data.source.remote

import com.vietis.themovies.data.model.ActorResponse
import com.vietis.themovies.data.model.MovieListResponse
import com.vietis.themovies.data.model.MovieResponse
import com.vietis.themovies.data.model.VideoResponse
import com.vietis.themovies.util.api.ApiEndPoint
import com.vietis.themovies.util.api.ApiEndPoint.PARAMS_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET(ApiEndPoint.GET_POPULAR_MOVIE)
    fun getPopularMovies(): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_TOP_RATE_MOVIE)
    fun getTopRateMovies(): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_UPCOMING_MOVIE)
    fun getUpComingMovies(): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_MOVIE_BY_GENRE)
    fun getMovieByGenre(@Path(PARAMS_ID) genreId: Int): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_DETAIL_MOVIE)
    fun getDetailMovie(@Path(PARAMS_ID) movieId: Int): Response<MovieResponse>

    @GET(ApiEndPoint.GET_ACTOR_OF_MOVIE)
    fun getActor(@Path(PARAMS_ID) movieId: Int): Response<ActorResponse>

    @GET(ApiEndPoint.GET_RECOMMEND_MOVIE)
    fun getRecommendMovie(@Path(PARAMS_ID) movieId: Int): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_VIDEO)
    fun getVideo(@Path(PARAMS_ID) movieId: Int): Response<VideoResponse>
}
