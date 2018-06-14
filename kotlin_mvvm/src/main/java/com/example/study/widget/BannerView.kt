package com.example.study.widget

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.kotlin_mvvm.R
import com.example.study.utils.DimensionUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import io.reactivex.disposables.Disposable
import java.util.*


/**
 * Created by xhu_ww on 2018/6/13.
 * description:
 */
class BannerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mLayoutResId = R.layout.layout_banner
    private var viewPager: ViewPager
    private var imageIndicatorLayout: ImageIndicatorLayout

    private var currentPosition: Int = 0
    private var mDisposable: Disposable? = null

    private var intervals = 3L
    private var isCanScroll = true

    var imageUrls: List<String>? = null
        set(value) {
            field = value
            if (value == null) {
                return
            }
            initView(value)
        }

    init {
        val view = LayoutInflater.from(context).inflate(mLayoutResId, this, true)

        viewPager = view.findViewById(R.id.viewPager)
        imageIndicatorLayout = view.findViewById(R.id.indicatorLayout)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                currentPosition = position
                imageIndicatorLayout.setSelected(position)
            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView(imageUrls: List<String>) {
        val adapter = ImagePagerAdapter(imageUrls, context, viewPager)
        viewPager.adapter = adapter
        viewPager.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    isCanScroll = false
                }

                MotionEvent.ACTION_UP -> {
                    isCanScroll = true
                }

            }
            false
        }

        imageIndicatorLayout.indicatorSize = imageUrls.size
    }

    private fun scroll() {
        if (!isCanScroll) {
            return
        }

        currentPosition++
        if (currentPosition == (imageUrls!!.size)) {
            currentPosition = 0
        }
        viewPager.currentItem = currentPosition
    }

    fun startAutoPlay() {
        if (imageUrls == null || imageUrls!!.isEmpty()) {
            return
        }

        mDisposable = Observable
                .interval(intervals, intervals, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    scroll()
                }
    }

    fun stopAutoPlay() {
        if (mDisposable != null) {
            mDisposable!!.dispose()
            mDisposable = null
        }
    }

}

class ImageIndicatorLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val views = ArrayList<View>()
    private var currentPosition = 0
    private var childWidth = DimensionUtil.dp2px(getContext(), 16F)
    private var childMargin = DimensionUtil.dp2px(getContext(), 10F)
    private val resource = R.drawable.selector_point

    init {
        val array = getContext().obtainStyledAttributes(attrs, R.styleable.ImageIndicatorLayout)
        childWidth = array.getDimension(R.styleable.ImageIndicatorLayout_pointWidth, 12f).toInt()
        childMargin = array.getDimension(R.styleable.ImageIndicatorLayout_pointMargin, 10f).toInt()
        array.recycle()
    }

    var indicatorSize: Int = 0
        set(value) {
            this.removeAllViews()
            views.clear()

            for (i in 0 until value) {
                val view = View(context)
                val params = LinearLayout.LayoutParams(childWidth, childWidth)
                params.leftMargin = childMargin
                params.rightMargin = childMargin
                view.setBackgroundResource(resource)
                view.isSelected = i == 0
                this.addView(view, params)
                views.add(view)
            }
        }

    fun setSelected(position: Int) {
        if (views.isEmpty() || position > views.size - 1)
            return
        views.forEach { v -> v.isSelected = false }
        views[position].isSelected = true
        currentPosition = position
    }
}


class ImagePagerAdapter(var imageUrlList: List<String>,
                        var context: Context, var viewPager: ViewPager) : PagerAdapter() {


    var linstener: CustomClickListener? = null


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageUrlList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imageView = ImageView(context)
//        var errorDrawable: Drawable = context.resources.getDrawable(0)

        Glide.with(imageView)
                .load(imageUrlList[position])
                .into(imageView)

        if (linstener != null) {
            imageView.setOnClickListener { _ -> linstener!!.onClick(position) }
        }
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    interface CustomClickListener {
        fun onClick(position: Int)
    }

}
