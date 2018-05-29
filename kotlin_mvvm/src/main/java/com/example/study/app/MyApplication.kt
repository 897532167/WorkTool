package com.example.study.app

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.study.di.component.DaggerMyApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
class MyApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector

    override fun onCreate() {
        super.onCreate()
        DaggerMyApplicationComponent.create().inject(this)
    }
}