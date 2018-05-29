package com.example.study.base

import android.content.Intent
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by xhu_ww on 2018/5/29.
 * description:加载Fragment的时候 继承于此类
 */
abstract class BaseFragmentActivity<B : ViewDataBinding, V : BaseViewModel> : BaseActivity<B, V>() {
    /**
     * 加载Fragment的layout ID
     */
    abstract fun fragmentContainerId(): Int

    /**
     * 加载一个新的Fragment
     */
    protected fun jumpFragment(fragment: Fragment) {
        supportFragmentManager.inTransaction {
            add(fragmentContainerId(), fragment).addToBackStack(fragment.javaClass.name)
        }
    }

    /**
     * 让包含的Fragment能接收到Activity的 onActivityResult
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = supportFragmentManager.findFragmentById(fragmentContainerId())
        fragment.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }

    fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }
}