package com.example.study.di.component

import com.example.study.app.MyApplication
import com.example.study.di.module.HomeFragmentModule
import com.example.study.di.module.MainActivityModule
import dagger.Component

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
@Component(modules = [MainActivityModule::class, HomeFragmentModule::class])
interface MyApplicationComponent {
    fun inject(application: MyApplication)
}