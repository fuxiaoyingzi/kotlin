package com.shadow.base.rx

import com.shadow.base.common.BaseResultCode
import com.shadow.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Author : shadow
 * Desc : 通用的类型 转换成实体类型
 * Date :2018/6/4/004
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        return if (t.status != BaseResultCode.SUCCESS) {//失败
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(t.data)
        }
    }

}