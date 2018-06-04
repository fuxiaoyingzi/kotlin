package com.shadow.base.ext

import com.shadow.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Author : shadow
 * Desc : 通用扩展
 * Date :2018/6/3/003
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>, lifeProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .compose(lifeProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}