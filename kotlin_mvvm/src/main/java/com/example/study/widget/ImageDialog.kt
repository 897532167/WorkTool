package com.example.study.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kotlin_mvvm.R

/**
 * Created by xhu_ww on 2018/6/14.
 * description:
 */

class ImageDialog(context: Context) : Dialog(context, R.style.DialogStyle) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.layout_image_dialog, null)
        this.setContentView(view)
    }

    fun show(url: String) {
        this.show()
        val ivBack = this.findViewById<ImageView>(R.id.iv_exit)
        val imageView = this.findViewById<ImageView>(R.id.dialog_imageView)
        Glide.with(imageView)
                .load(url)
                .into(imageView)
        ivBack.setOnClickListener { dismiss() }
    }

}
