package com.shadow.base.rx

import rx.Subscriber

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
open class BaseSubscriber<T> : Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}