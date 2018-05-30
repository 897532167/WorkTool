package com.example.study.mvvm.viewmodel

import com.example.study.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
class LoginViewModel : BaseViewModel {
    @Inject
    constructor()

    fun getName(): String {
        return "TEST_DAGGER2"
    }
}