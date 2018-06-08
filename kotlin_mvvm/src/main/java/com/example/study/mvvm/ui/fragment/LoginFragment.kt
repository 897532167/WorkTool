package com.example.study.mvvm.ui.fragment

import android.view.View
import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.FragmentLoginBinding
import com.example.study.base.BaseFragment
import com.example.study.base.EmptyViewModel

/**
 * Created by xhu_ww on 2018/6/8.
 * description:
 */
class LoginFragment : BaseFragment<FragmentLoginBinding, EmptyViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun init() {
    }

    override fun initView(rootView: View) {
    }

    override fun showData() {
    }

}