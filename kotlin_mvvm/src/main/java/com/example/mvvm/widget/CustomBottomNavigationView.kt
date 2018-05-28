package com.example.mvvm.widget

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.AttributeSet

/**
 * Created by xhu_ww on 2018/5/28.
 * description:
 */
class CustomBottomNavigationView : BottomNavigationView {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        disableShiftMode()
    }

    @SuppressLint("RestrictedApi")
    private fun disableShiftMode() {
        try {
            val menuView = getChildAt(0) as BottomNavigationMenuView
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false

            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}
