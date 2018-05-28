package com.example.mvvm.base

import android.app.Application
import com.example.mvvm.di.component.ActivityComponent
import com.example.mvvm.di.component.DaggerActivityComponent
import com.example.mvvm.di.module.ActivityModule

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
class BaseApplication : Application() {
    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var component: ActivityComponent
    }
    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    fun createComponent() {
        component = DaggerActivityComponent.builder()
                .activityModule(ActivityModule())
                .build()
        component.inject(this)
    }

}