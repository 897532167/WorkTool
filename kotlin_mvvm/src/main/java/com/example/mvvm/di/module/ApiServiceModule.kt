package com.zyelite.kghub.dagger.module

import com.zyelite.kghub.http.api.EventService
import com.zyelite.kghub.http.api.LoginService
import com.zyelite.kghub.http.api.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author zy
 * @date 2018/3/5
 * @des LoginServiceModule
 */
@Module
class ApiServiceModule {

    @Provides
    fun provideLogin(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    fun provideUser(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun provideEvent(retrofit: Retrofit): EventService {
        return retrofit.create(EventService::class.java)
    }
}