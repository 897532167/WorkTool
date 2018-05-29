package com.example.study.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
open class BaseViewModel {
    @Inject
    constructor()

    /**
     * 将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
     */
    private var mCompositeDisposable: CompositeDisposable? = null

    protected fun addDisposable(subscription: Disposable) {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            this.mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(subscription)
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    fun dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.dispose()
        }
        this.mCompositeDisposable = null
    }
}