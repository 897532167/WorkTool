package com.example.study.utils

import android.content.Context
import com.google.gson.Gson

/**
 * Created by xhu_ww on 2018/5/30.
 * description: 本地JSON文件读取
 */
class LocalJsonReadUtil {
    companion object {
        fun getJson(context: Context, fileName: String): String {
            return context.assets
                    .open(fileName)
                    .buffered()
                    .reader(Charsets.UTF_8)
                    .readText()
        }

        fun <T> jsonToObject(json: String, type: Class<T>): T {
            return Gson().fromJson(json, type)
        }

        /**
         * 从 assets 文件中得到json 并转化为对应对象
         */
        fun <T> jsonToObject(context: Context, fileName: String, type: Class<T>): T {
            return Gson().fromJson(getJson(context, fileName), type)
        }
    }
}