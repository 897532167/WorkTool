package com.example.study.mvvm.model.net

import retrofit2.HttpException

/**
 * Created by xhu_ww on 2018/5/30.
 * description:
 */
interface NetworkError {
    class HttpError(val error: HttpException) : NetworkError {
        val code: Int
            get() = error.code()
    }

    class TimeoutError : NetworkError
}