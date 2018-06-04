package com.shadow.base.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.support.annotation.NonNull
import android.support.annotation.StyleRes
import android.view.Gravity
import android.widget.ImageView
import com.shadow.base.R

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
class ProgressDialog private constructor(@NonNull context: Context, @StyleRes themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        lateinit var mDialog: ProgressDialog;
        var animDrawableRes: AnimationDrawable? = null
        fun create(context: Context): ProgressDialog {
            mDialog = ProgressDialog(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window.attributes.gravity = Gravity.CENTER
            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp

            animDrawableRes = mDialog.findViewById<ImageView>(R.id.iv_loading).background as AnimationDrawable
            return mDialog
        }
    }

    override fun show() {
        super.show()
        animDrawableRes?.start()
    }

    override fun dismiss() {
        super.dismiss()
        animDrawableRes?.stop()
    }
}