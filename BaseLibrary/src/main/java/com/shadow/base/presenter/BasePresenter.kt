package com.shadow.base.presenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.shadow.base.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        return if (NetWorkUtils.isNetWorkAvailable(context)) {
            true
        } else {
            mView.onError("网络不可用")
            false
        }
    }
}