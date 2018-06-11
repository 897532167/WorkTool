package com.example.study.mvvm.ui.activity

import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.ActivityMainBinding
import com.example.study.base.BaseFragmentActivity
import com.example.study.mvvm.ui.fragment.HomeFragment
import com.example.study.mvvm.ui.fragment.LoginFragment
import com.example.study.mvvm.ui.fragment.RegisterFragment
import com.example.study.mvvm.viewmodel.LoginViewModel

class MainActivity : BaseFragmentActivity<ActivityMainBinding, LoginViewModel>() {
    lateinit var fragment: RegisterFragment

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun fragmentContainerId(): Int = R.id.fl_container

    override fun init() {
        fragment = RegisterFragment()
    }

    override fun initView() {
        addFragment(fragment)
    }

    override fun showData() {
    }

    override fun onBackPressed() {
        finish()
    }
}
