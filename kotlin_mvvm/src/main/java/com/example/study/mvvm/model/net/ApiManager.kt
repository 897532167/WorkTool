package com.example.study.mvvm.model.net

import android.util.Log
import com.example.study.app.AppConfig
import com.example.study.mvvm.model.api.LoginService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */
class ApiManager {

    val loginService: LoginService by lazy { getRetrofit().create(LoginService::class.java) }

    private fun getRetrofit(): Retrofit {
        //日志打印拦截
        val interceptor = HttpLoggingInterceptor { message -> Log.e("TAG", "REQUEST：----$message") }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        //网络请求头 避免网络请求出现汉字时乱码
        val interceptorHeader = Interceptor { chain ->
            val request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8") //添加请求
                    .build()
            return@Interceptor chain.proceed(request)
        }
        val okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .addInterceptor(interceptorHeader)
                .build()

        // 获取retrofit的实例
        return Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)  //自己配置
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}