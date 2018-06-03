package com.shadow.usercenter.service.impl

import com.shadow.base.rx.BaseException
import com.shadow.usercenter.data.repository.UserRepository
import com.shadow.usercenter.service.UserRegister
import rx.Observable

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserRegisterImpl : UserRegister {
    override fun register(phoneNum: String, pwd: String, authCode: String): Observable<Boolean> {
        val repository = UserRepository()
        return repository.register(phoneNum, pwd, authCode).flatMap { t ->
            if (t.status != 0) {//失败
                Observable.error(BaseException(t.status, t.message))
            } else {
                Observable.just(true)
            }
        }
    }

}