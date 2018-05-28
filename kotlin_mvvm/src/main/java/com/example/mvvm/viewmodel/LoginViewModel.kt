package com.example.mvvm.viewmodel

import com.example.mvvm.base.BaseViewModel
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