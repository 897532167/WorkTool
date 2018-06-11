package com.example.study.di.module

import com.example.study.mvvm.ui.fragment.HomeFragment
import com.example.study.mvvm.ui.fragment.LoginFragment
import com.example.study.mvvm.ui.fragment.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun registerFragment(): RegisterFragment

}