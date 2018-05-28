package com.example.mvvm.di.module

import com.example.mvvm.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides

/**
 * 作者：xhu_ww on 2018/5/29.
 * 描述：
 */
@Module
class ActivityModule() {
    @Provides
    fun getLoginMode(): LoginViewModel {
        return LoginViewModel()
    }
}