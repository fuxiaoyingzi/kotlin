package com.shadow.usercenter.service.impl

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.ext.convert
import com.shadow.base.ext.convertBoolean
import com.shadow.usercenter.data.repository.UserRepository
import com.shadow.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Author : shadow
 * Desc : 服务器json 数据 转换为 实体数据
 * Date :2018/6/3/003
 */
class UserServiceImpl @Inject constructor() : UserService {

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

    override fun editUserInfo(userIcon: String, userName: String, userSex: String, userSign: String): Observable<UserInfo> {
        return repository.editUserInfo(userIcon, userName, userSex, userSign).convert()
    }

}