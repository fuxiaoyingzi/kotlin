package com.shadow.base.utils

import android.support.annotation.StringRes
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.shadow.base.common.BaseApplication


/**
 * Author : shadow
 * Desc :
 * Date :2018/3/23/023
 */

object ToastUtil {
    fun showMsg(msg: CharSequence) {
        Toast.makeText(BaseApplication.Companion.instance, msg, Toast.LENGTH_SHORT).show()
    }

    fun showMsg(@StringRes resId: Int) {
        Toast.makeText(BaseApplication.Companion.instance, resId, Toast.LENGTH_SHORT).show()
    }

    fun s(msg: CharSequence?) {
        if (msg != null) showMsg(msg)
    }

    fun s(@StringRes resId: Int) {
        showMsg(resId)
    }

    fun sl(msg: CharSequence?) {
        if (msg != null) showMsgLong(msg)
    }

    fun sl(@StringRes resId: Int) {
        showMsgLong(resId)
    }

    fun showMsgLong(msg: CharSequence) {
        Toast.makeText(BaseApplication.Companion.instance, msg, Toast.LENGTH_LONG).show()
    }

    fun showMsgLong(@StringRes resId: Int) {
        Toast.makeText(BaseApplication.Companion.instance, resId, Toast.LENGTH_LONG).show()
    }

    @JvmOverloads
    fun showCustomMsg(view: View, duration: Int = Toast.LENGTH_SHORT) {
        showCustomMsg(view, Toast.LENGTH_SHORT, Gravity.CENTER)
    }

    fun showCustomMsg(view: View, duration: Int, gravity: Int) {
        val toast = Toast(BaseApplication.Companion.instance)
        toast.view = view
        toast.setGravity(gravity, 0, 0)
        toast.duration = duration
        toast.show()
    }

}
