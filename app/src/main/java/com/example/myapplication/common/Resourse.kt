package com.example.myapplication.common

class Resourse<T>(
    val date: T,
    val message: String?,
    val status: Status
) {
    companion object {
        fun <T> success(date: T): Resourse<T> {
            return Resourse(date, null, Status.SUCCESS)
        }

        fun <T> loading(): Resourse<T?> {
            return Resourse(null, null, Status.LOADING)
        }

        fun <T> error(message: String?): Resourse<T?> {
            return Resourse(null, message, Status.ERROR)
        }
    }

    enum class Status {
        SUCCESS,
        LOADING,
        ERROR
    }
}