package com.example.study.mvvm.ui.fragment

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.View
import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.databinding.FragmentHomeBinding
import com.example.study.base.BaseFragment
import com.example.study.mvvm.model.data.ChartDataBean
import com.example.study.mvvm.model.data.ClientAccumulativeRate
import com.example.study.mvvm.viewmodel.HomeFragmentViewModel
import com.example.study.utils.HttpThread
import com.example.study.utils.LocalJsonReadUtil
import com.example.study.widget.ImageDialog
import com.example.study.widget.ImagePagerAdapter

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {

    lateinit var chartData: ClientAccumulativeRate
    lateinit var urlList: List<String>

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun init() {
        chartData = LocalJsonReadUtil.jsonToObject(context!!, "chart.json", ChartDataBean::class.java)
                .GRID0
                .result
                .clientAccumulativeRate[0]

        urlList = mutableListOf(
                "http://img2.imgtn.bdimg.com/it/u=3588772980,2454248748&fm=27&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=594559231,2167829292&fm=27&gp=0.jpg",
                "http://img3.imgtn.bdimg.com/it/u=2249893882,1165836821&fm=27&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=302701032,2300144492&fm=27&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=1747088621,256464918&fm=27&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=3729188735,351366433&fm=27&gp=0.jpg"
        )

    }

    override fun initView(rootView: View) {
//        val adapter = ImagePagerAdapter(urlList, this.context!!, binding.viewPager)
//        binding.viewPager.adapter = adapter
//        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrollStateChanged(state: Int) {
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//                binding.indicatorLayout.setSelected(position)
//            }
//
//        })
//        binding.indicatorLayout.indicatorSize = urlList.size
        binding.fragment = this
        binding.bannerView.imageUrls = urlList
        binding.bannerView.startAutoPlay()

    }

    override fun showData() {

    }

    fun showDialog(view: View) {
        val dialog = ImageDialog(activity as Context)
        dialog.show(urlList[1])
        toast("点击")
    }

}