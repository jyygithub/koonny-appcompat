package com.koonny.sample.retrofit

sealed class ApiResult<out T>(val status: Int, private val data: T?, val message: String?) {

    data class Success<out R>(val value: R?) : ApiResult<R>(0, value, null)

    data class Failure(val errorMessage: String) : ApiResult<Nothing>(1, null, errorMessage)

    data class Loading(val loadingMessage: String) : ApiResult<Nothing>(2, null, loadingMessage)

}

suspend fun <T : Any> ApiResult<T>.onSuccess(executable: suspend (value: T?) -> Unit): ApiResult<T> = apply {
    if (this is ApiResult.Success) {
        executable(value)
    }
}

suspend fun <T : Any> ApiResult<T>.onFailure(executable: suspend (code: Int, message: String) -> Unit): ApiResult<T> = apply {
    if (this is ApiResult.Failure) {
        executable(status, errorMessage)
    }
}

suspend fun <T : Any> ApiResult<T>.onLoading(executable: suspend (loadingMessage: String) -> Unit): ApiResult<T> = apply {
    if (this is ApiResult.Loading) {
        executable(loadingMessage)
    }
}