package com.example.study.di.module

import android.support.v4.app.Fragment
import com.example.study.di.component.HomeFragmentSubComponent
import dagger.Module
import com.example.study.mvvm.ui.fragment.HomeFragment
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.android.support.FragmentKey


/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
@Module(subcomponents = [(HomeFragmentSubComponent::class)])
internal abstract class HomeFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    abstract fun bindHomeFragmentInjectorFactory(builder: HomeFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>
}