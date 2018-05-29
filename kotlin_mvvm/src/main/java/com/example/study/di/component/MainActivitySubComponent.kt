package com.example.study.di.component

import com.example.study.mvvm.ui.activity.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
@Subcomponent(modules = [AndroidInjectionModule::class])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}