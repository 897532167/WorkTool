package com.example.study.di.component

import com.example.study.app.MyApplication
import com.example.study.di.module.ActivityBuilderComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilderComponent::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MyApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApplication)
}