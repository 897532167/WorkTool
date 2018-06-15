package com.example.study.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by xhu_ww on 2018/5/29.
 * description: support 下的Fragment
 *
 */
abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {

    lateinit var binding: B
    val TAG = this.javaClass.name

    @Inject
    lateinit var viewModel: V

    protected lateinit var mRootView: View
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
    abstract fun initView(rootView: View)

    /**
     * 展示数据
     */
    abstract fun showData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView(view)
        showData()
        Log.i(TAG, "---------onViewCreated")
    }

    fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        viewModel.dispose()
        Log.i(TAG, "---------onDestroy")
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "---------onResume")
    }

}