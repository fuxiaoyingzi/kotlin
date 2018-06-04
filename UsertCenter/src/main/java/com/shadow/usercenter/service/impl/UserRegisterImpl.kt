package com.shadow.usercenter.service.impl

import com.shadow.base.ext.convertBoolean
import com.shadow.usercenter.data.repository.UserRepository
import com.shadow.usercenter.service.UserRegister
import rx.Observable
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserRegisterImpl @Inject constructor() : UserRegister {
    @Inject
    lateinit var repository: UserRepository

    override fun register(phoneNum: String, pwd: String, authCode: String): Observable<Boolean> {
        return repository.register(phoneNum, pwd, authCode)
                .convertBoolean()
    }

}