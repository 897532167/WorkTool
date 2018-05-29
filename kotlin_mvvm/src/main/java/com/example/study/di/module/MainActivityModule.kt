package com.example.study.di.module

import dagger.Module
import android.app.Activity
import com.example.study.di.component.MainActivitySubComponent
import com.example.study.mvvm.ui.activity.MainActivity
import dagger.android.AndroidInjector
import dagger.android.ActivityKey
import dagger.multibindings.IntoMap
import dagger.Binds



/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
@Module(subcomponents = [(MainActivitySubComponent::class)])
internal abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindYourActivityInjectorFactory(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}