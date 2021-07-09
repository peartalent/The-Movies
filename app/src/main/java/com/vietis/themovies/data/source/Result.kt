package com.vietis.themovies.data.source

data class Result<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val code: Int = 0
) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String? = null, data: T? = null, code: Int = 0): Result<T> {
            return Result(Status.ERROR, data, message, code)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }
}