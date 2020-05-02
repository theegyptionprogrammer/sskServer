package com.example.sskServer.utils

sealed class DefaultResponse {

    data class Success(val statusCode: Int,
                       val message: String,
                       val data: String): DefaultResponse()

    data class Error(val statusCode: Int,
                     val message: String,
                     val error: String?): DefaultResponse()
}