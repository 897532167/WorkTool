package com.example.mvvm.di

import com.example.mvvm.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
@Module
class MainModule {
    /**
     * @Provides 注解表示这个方法是用来创建某个实例对象的，这里我们创建返回Gson对象
     * 方法名随便，一般用provideXXX结构
     * @return 返回注入对象
     */
    @Provides
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel()
    }
}