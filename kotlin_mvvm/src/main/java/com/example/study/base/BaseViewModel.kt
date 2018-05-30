package com.example.study.base

import android.databinding.ObservableField
import com.example.study.mvvm.model.net.NetworkError
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.CompositeException
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
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
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    fun dispose() {
        compositeDisposable.dispose()
    }

    fun <T> async(): ObservableTransformer<T, T> =
            ObservableTransformer {
                it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            }

    fun <T> disposable(): ObservableTransformer<T, T> {
        lateinit var disposable: Disposable
        return ObservableTransformer {
            it.doOnSubscribe {
                disposable = it
                compositeDisposable.add(it)
            }.doFinally {
                compositeDisposable.remove(disposable)
            }
        }
    }

    fun <T> networkError(value: ObservableField<NetworkError>): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.doOnSubscribe({
                value.set(null)
            }).doOnError({
                val httpException = getHttpException(it)
                if (httpException != null)
                    value.set(NetworkError.HttpError(httpException))
                else
                    value.set(NetworkError.TimeoutError())
            })
        }
    }

    private fun getHttpException(e: Throwable): HttpException? {
        if (e is HttpException) return e

        return if (e is CompositeException) {
            e.exceptions.first { it is HttpException } as HttpException?
        } else null
    }
}