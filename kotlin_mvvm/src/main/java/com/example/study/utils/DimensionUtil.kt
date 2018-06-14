package com.example.study.utils

import android.content.Context
import android.util.TypedValue

/**
 * Created by xhu_ww on 2018/6/13.
 * description:
 */
object DimensionUtil {
    private fun applyDimension(context: Context, value: Float, unit: Int): Float {
        return TypedValue.applyDimension(unit, value, context.resources.displayMetrics)
    }

    private fun applyDimensionPixelSize(context: Context, value: Float, unit: Int): Int {
        return applyDimension(context, value, unit).toInt()
    }

    fun dp2px(context: Context, value: Float): Int {
        return applyDimensionPixelSize(context, value, TypedValue.COMPLEX_UNIT_DIP)
    }

    fun dp(context: Context, value: Float): Float {
        return applyDimension(context, value, TypedValue.COMPLEX_UNIT_DIP)
    }

    fun sp2px(context: Context, value: Float): Int {
        return applyDimensionPixelSize(context, value, TypedValue.COMPLEX_UNIT_SP)
    }

    fun sp(context: Context, value: Float): Float {
        return applyDimension(context, value, TypedValue.COMPLEX_UNIT_SP)
    }

    fun mm2px(context: Context, value: Float): Int {
        return applyDimensionPixelSize(context, value, TypedValue.COMPLEX_UNIT_MM)
    }
}
