package com.example.mvvm.di

import com.example.mvvm.MainActivity
import dagger.Component

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
@Component(modules = [MainModule::class])
interface MainComponent {

    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性 被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    fun inject(activity: MainActivity)
}
