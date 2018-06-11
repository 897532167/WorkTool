package com.example.study.di.component

import android.app.Application
import com.example.study.app.MyApplication
import com.example.study.di.module.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.android.AndroidInjector


/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBindingModule::class])
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}