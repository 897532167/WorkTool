package com.example.study.mvvm.ui.fragment

import android.view.View
import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.FragmentHomeBinding
import com.example.study.base.BaseFragment
import com.example.study.mvvm.viewmodel.HomeFragmentViewModel

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {


    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun init() {

    }

    override fun initView(rootView: View) {
    }

    override fun showData() {
    }
}