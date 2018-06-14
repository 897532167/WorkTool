package com.example.study.utils

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by xhu_ww on 2018/6/14.
 * description:
 */
class HttpThread : Thread {
    var baseUrl: String = "https://54.248.66.37/api/account?uuid=02FE29AB-F342-4BF5-923A-DCDEDE0ADFA7&auth_token=9b08596b778f54770936b8387fd8a091"

    constructor(baseUrl: String) : super(baseUrl) {
        this.baseUrl = baseUrl    //构造方法传值
    }

    override fun run() {
        super.run()
        var url = URL(baseUrl)

        if ("https".equals(url.protocol, true)) {
            SslUtil.ignoreSsl()
        }

        var httpConnect = url.openConnection() as HttpURLConnection

        httpConnect.connectTimeout = 5 * 1000  // 设置连接超时时间
        httpConnect.readTimeout = 5 * 1000  //设置从主机读取数据超时
        httpConnect.doOutput = true
        httpConnect.doInput = true
        httpConnect.useCaches = false
        httpConnect.requestMethod = "GET" // 设置为Post请求
        httpConnect.connect() // 开始连接

        var inputStream = if (httpConnect.responseCode > 400) {
            httpConnect.errorStream
        } else {
            httpConnect.inputStream
        }

        var reader = BufferedReader(InputStreamReader(inputStream))
        var strBuilder = StringBuilder()
        reader.forEachLine {
            strBuilder.append(it)
        }

        Log.e("TAG", strBuilder.toString())
        inputStream.close()
        reader.close()
    }
}