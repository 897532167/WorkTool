package com.example.study.mvvm.ui.fragment

import android.view.View
import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.FragmentHomeBinding
import com.example.study.base.BaseFragment
import com.example.study.mvvm.model.data.ChartDataBean
import com.example.study.mvvm.model.data.ClientAccumulativeRate
import com.example.study.mvvm.viewmodel.HomeFragmentViewModel
import com.example.study.utils.LocalJsonReadUtil

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {
    lateinit var chartData: ClientAccumulativeRate

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun init() {
        chartData = LocalJsonReadUtil.jsonToObject(context!!, "chart.json", ChartDataBean::class.java)
                .GRID0
                .result
                .clientAccumulativeRate[0]
    }

    override fun initView(rootView: View) {
        binding.textView.text = chartData.tradeDate
    }

    override fun showData() {
//        viewModel.requestData()
    }
}