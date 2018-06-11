package com.example.study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * Created by xhu_ww on 2018/6/11.
 * description: 倒计时控件
 */
class CountDownView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr), Runnable {

    var run = false
    var endHint: String = ""
    var count: Int = 0

    @SuppressLint("SetTextI18n")
    override fun run() {
        if (run && count > 0) {
            this.text = count.toString() + "s"
            postDelayed(this, 1000)
            count--
        } else {
            run = false
            if (endHint.isEmpty()) {
                this.text = endHint
            } else {
                this.text = "0s"
            }
        }
    }

    fun stopRun() {
        this.run = false
    }

    fun startRun() {
        this.run = true
        run()
    }
}