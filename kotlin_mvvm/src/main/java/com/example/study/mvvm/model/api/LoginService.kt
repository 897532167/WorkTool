package com.example.study.mvvm.model.api

import io.reactivex.Observable
import junit.framework.Test
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by xhu_ww on 2018/5/30.
 * description:
 */
interface LoginService {
    @FormUrlEncoded
    @POST("/api/auth/appLogin")
    fun login(@Field("username") name: String,
              @Field("password") password: String): Observable<Test>


}