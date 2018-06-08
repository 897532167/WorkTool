package com.example.study.widget

import android.content.Context
import android.graphics.Color
import android.support.graphics.drawable.VectorDrawableCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.kotlin_mvvm.R


/**
 * Created by xhu_ww on 2018/5/9.
 * description:左右两条线、中间文本描述
 */
class DivisionLayoutView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var drawable: VectorDrawableCompat? = null
    private var text: String? = null

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.DivisionLayoutView)
        for (i in 0 until array.indexCount) {
            val attr = array.getIndex(i)
            when (attr) {
                R.styleable.DivisionLayoutView_divisionDrawable -> {
                    val id = array.getResourceId(attr, -1)
                    drawable = VectorDrawableCompat.create(context.resources, id, context.theme)
                }
                R.styleable.DivisionLayoutView_divisionText ->
                    text = array.getString(attr)
            }
        }

        array.recycle()
        addView(getDivisionLine(context, false))
        if (drawable != null) addView(getImageView(context))
        addView(getTextView(context))
        addView(getDivisionLine(context, true))
    }

    private fun getDivisionLine(context: Context, isRight: Boolean): View {
        val view = View(context)
        val params = LinearLayout.LayoutParams(0, 1)
        params.weight = 1f
        params.leftMargin = if (isRight) 5 else 15
        if (isRight) params.rightMargin = 15
        view.layoutParams = params
        view.setBackgroundColor(Color.parseColor("#4d4d4d"))
        return view
    }

    private fun getImageView(context: Context): ImageView {
        val view = ImageView(context)
        view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        view.setImageDrawable(drawable)
        view.setPadding(5, 0, 3, 0)
        return view
    }

    private fun getTextView(context: Context): TextView {
        val view = TextView(context)
        view.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        view.gravity = Gravity.CENTER
        view.textSize = 13f
        if (text != null) view.text = text
        return view
    }
}
