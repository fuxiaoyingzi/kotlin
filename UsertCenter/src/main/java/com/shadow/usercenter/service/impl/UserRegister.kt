package com.shadow.usercenter.service.impl

import com.shadow.usercenter.service.UserRegister
import rx.Observable

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserRegisterImpl : UserRegister {
    override fun register(phoneNum: String, authCode: String): Observable<Boolean> {
        return Observable.just(true)
    }

}