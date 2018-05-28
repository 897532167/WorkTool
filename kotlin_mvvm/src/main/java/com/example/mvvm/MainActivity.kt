package com.example.mvvm

import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.ActivityMainBinding
import com.example.mvvm.base.BaseActivity
import com.example.mvvm.viewmodel.LoginViewModel

class MainActivity : BaseActivity<ActivityMainBinding, LoginViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
    }

    override fun initView() {
        binding.textview.text = viewModel.getName()
    }

    override fun showData() {
    }



}
