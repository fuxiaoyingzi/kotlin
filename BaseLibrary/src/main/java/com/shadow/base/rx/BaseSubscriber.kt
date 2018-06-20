package com.shadow.base.rx

import com.shadow.base.presenter.view.BaseView
import rx.Subscriber

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
open class BaseSubscriber<T>(private val baseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.closeLoading()

    }

    override fun onError(e: Throwable?) {
        baseView.closeLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }
    }
}