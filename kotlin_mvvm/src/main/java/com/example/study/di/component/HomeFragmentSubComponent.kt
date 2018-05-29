package com.example.study.di.component

import com.example.study.mvvm.ui.fragment.HomeFragment
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(modules = [AndroidInjectionModule::class])
interface HomeFragmentSubComponent : AndroidInjector<HomeFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeFragment>()
}