package com.zyelite.kghub.dagger.module

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.google.gson.GsonBuilder
import com.zyelite.kghub.KConfig
import com.zyelite.kghub.http.core.HttpsUtils
import com.zyelite.kghub.http.core.Tls12SocketFactory
import com.zyelite.kghub.http.interceptor.OKHttpCacheInterceptor
import com.zyelite.kghub.http.interceptor.OKHttpCacheNetworkInterceptor
import com.zyelite.kghub.utils.Constant
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import javax.inject.Singleton
import javax.net.ssl.SSLContext

/**
 * @author zy
 * @date 2018/2/28
 * @des ApiModule
 */
@Module
class ApiModule(private var context: Context) {

    //提供唯一上下文
    @Singleton
    @Provides
    fun privateContext() = context;


    /**
     * 配置retrofit客户端
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient())
                    .baseUrl(KConfig.GITHUB_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()!!

    /**
     * 设置缓存
     */
    private fun okHttpClient(): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)

        val builder = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(provideInterceptor())
                .addInterceptor(OKHttpCacheInterceptor())
                .addInterceptor({
                    val string = context.getSharedPreferences("KGHub", Context.MODE_PRIVATE)
                            .getString(Constant.TOKEN, "")
                    if (!TextUtils.isEmpty(string)) {
                        it.proceed(it.request().newBuilder().addHeader("Authorization", string).build())
                    } else {
                        it.proceed(it.request())
                    }
                })

                .addNetworkInterceptor(OKHttpCacheNetworkInterceptor())
            var sslContext: SSLContext? = null
            try {
                sslContext = SSLContext.getInstance("TLS")
                try {
                    sslContext!!.init(null, null, null)
                } catch (e: KeyManagementException) {
                    e.printStackTrace()
                }

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            val socketFactory = Tls12SocketFactory(sslContext!!.socketFactory)
            builder.sslSocketFactory(socketFactory, HttpsUtils.UnSafeTrustManager())

        return builder .build()
    }



    /**
     * 网络请求拦截器
     */
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { msg ->
            Log.e("okhttp", msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


//    private val DEFAULT_TIMEOUT = 15
//    private val BASE_URL = "http://news-at.zhihu.com/api/4/"

//
//    @Singleton
//    @Provides
//    fun providerRetrofit(): Retrofit {
//
//        val client = OkHttpClient.Builder()
//                .retryOnConnectionFailure(true)
//                .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
//                .build()
//
//        return Retrofit.Builder()
//                .baseUrl(KConfig.GITHUB_API_BASE_URL)
//                .client(client)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//    }

}