package com.example.study.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.widget.Toast
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
open abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel> : DaggerAppCompatActivity() {
    lateinit var binding: B
    val TAG = this.javaClass.name

    @Inject
    lateinit var viewModel: V

    /**
     * 布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化数据 注：init 在 initView前
     */
    abstract fun init()

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 展示数据
     */
    abstract fun showData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        init()
        initView()
        showData()
    }

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }
}