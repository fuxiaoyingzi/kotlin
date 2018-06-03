package com.shadow.usercenter.data.repository

import com.shadow.base.data.net.RetrofitFactory
import com.shadow.base.data.protocol.BaseResp
import com.shadow.usercenter.data.api.UserApi
import com.shadow.usercenter.data.protocol.RegisterBody
import rx.Observable

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserRepository {
    fun register(phoneNum: String, pwd: String, authCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterBody(phoneNum, authCode, pwd))
    }
}