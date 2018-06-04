package com.shadow.usercenter.data.repository

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.data.net.RetrofitFactory
import com.shadow.base.data.protocol.BaseResp
import com.shadow.usercenter.data.api.UserApi
import com.shadow.usercenter.data.protocol.LoginReq
import com.shadow.usercenter.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserRepository @Inject constructor() {
    fun register(phoneNum: String, pwd: String, authCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(phoneNum, authCode, pwd))
    }

    fun login(phoneNum: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(phoneNum, pwd, pushId))
    }
}