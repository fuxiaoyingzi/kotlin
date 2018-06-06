package com.shadow.usercenter.service.impl

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.ext.convert
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

    override fun login(phoneNum: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(phoneNum, pwd, pushId)
                .convert()
    }

    override fun forgetPwd(phoneNum: String, authCode: String): Observable<Boolean> {
        return repository.forgetPwd(phoneNum, authCode).convertBoolean()
    }

    override fun resetPwd(phoneNum: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(phoneNum, pwd).convertBoolean()
    }


}