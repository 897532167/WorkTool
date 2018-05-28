package com.zyelite.kghub.dagger.component

import com.zyelite.kghub.App
import com.zyelite.kghub.dagger.module.ApiModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * @author zy
 * @date 2018/2/28
 * @des ApiComponent
 */
@Singleton
@Component(modules = [(ApiModule::class)])
interface ApiComponent {
    fun inject(app: App)

    fun retrofit(): Retrofit

}