package com.example.study.di.scope

import javax.inject.Scope

/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class FragmentScoped