package com.example.study.di.module

import com.example.study.mvvm.ui.activity.MainActivity
import dagger.Module
import com.example.study.di.scope.ActivityScope
import dagger.android.ContributesAndroidInjector


/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun mainActivity(): MainActivity
}