package com.example.study.di.module

import com.example.study.mvvm.ui.activity.MainActivity
import dagger.Module
import com.example.study.di.scope.ActivityScope
import dagger.android.ContributesAndroidInjector


/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */
//@Module(subcomponents = arrayOf(MainActivitySubcomponent::class))
@Module
abstract class ActivityBuilderComponent {

//    @ContributesAndroidInjector(modules = [MainActivitySubComponent::class])
//    @ActivityScope
//    abstract fun bindMyActivity(): MainActivity
}