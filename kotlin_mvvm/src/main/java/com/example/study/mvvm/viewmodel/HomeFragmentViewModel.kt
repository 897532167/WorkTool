package com.example.study.mvvm.viewmodel

import android.databinding.ObservableField
import com.example.study.base.BaseViewModel
import com.example.study.mvvm.model.net.NetworkError
import io.reactivex.*
import javax.inject.Inject

/**
 * Created by xhu_ww on 2018/5/29.
 * description:
 */
class HomeFragmentViewModel : BaseViewModel {
    @Inject constructor()

    var requestChartDataError: ObservableField<NetworkError> = ObservableField()

    fun requestData() {

        Observable.create<Int> { emitter ->
            emitter.onNext(1)
        }.compose(async())
                .compose(disposable())
                .compose(networkError(requestChartDataError))
                .subscribe({})
    }
}