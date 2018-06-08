package com.example.study.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by xhu_ww on 2018/6/8.
 * description: 水波纹TextView
 */
class RippleTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    //画笔
    private var mPaint: Paint? = null
    //波纹的中心点
    private var centPoint: PointF? = null
    //波纹初始半径
    private var initRadius = 0
    private var maxRadius = 0f

    private var isPress = false
    private val isShowRipple = Build.VERSION.SDK_INT >= 18

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (centPoint != null && isShowRipple) {
            initRadius += 20
            if (initRadius <= maxRadius) {
                canvas.drawCircle(centPoint!!.x, centPoint!!.y, initRadius.toFloat(), mPaint)
            } else {
                centPoint = null
            }
            postInvalidateDelayed(10)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (isShowRipple) {
            if (event.action == MotionEvent.ACTION_UP && !isPress) {
                isPress = true
                setCentPoint(event.x, event.y)
                //先让up事件吊起，当波纹动作完成后再传up事件
                postDelayed(DispatchUpTouchEventRunnable(event), (maxRadius / 20).toLong() * 10 + 400)
            } else if (event.action == MotionEvent.ACTION_DOWN) {
                isPress = false
            }
        }
        return true
    }

    private fun setCentPoint(x: Float, y: Float) {
        if (isShowRipple) {
            this.centPoint = PointF(x, y)
            if (mPaint == null) {
                mPaint = Paint()
                mPaint!!.isAntiAlias = true
                mPaint!!.alpha = 40
                mPaint!!.style = Paint.Style.FILL
            }
            initRadius = 0
            maxRadius = if (x >= width / 2) x else width - x
            invalidate()
        }
    }

    internal inner class DispatchUpTouchEventRunnable(var event: MotionEvent) : Runnable {

        override fun run() {
            this@RippleTextView.dispatchTouchEvent(event)
        }
    }
}
