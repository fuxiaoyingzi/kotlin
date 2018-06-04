package com.shadow.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.widgets.DefaultTextWatcher
import com.shadow.base.data.protocol.BaseResp
import com.shadow.base.rx.BaseFunc
import com.shadow.base.rx.BaseFuncBoolean
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

/**
 * 类型转换扩展
 */
fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

/**
 * Boolean 类型转换扩展
 */
fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

/**
 * 扩展view的onclick方法
 */
fun View.onclick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

/**
 * lambda表达式实现onclick方法
 * 函数可以作为参数传递
 */
fun View.onclick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

/**
 * 扩展事件，统一引用
 */
fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}



