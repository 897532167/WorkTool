package com.example.mvvm.di.component

import com.example.mvvm.MainActivity
import com.example.mvvm.base.BaseApplication
import com.example.mvvm.di.module.ActivityModule
import dagger.Component


/**
 * 作者：xhu_ww on 2018/5/29.
 * 描述：
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(application: BaseApplication)
}