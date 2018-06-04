package com.shadow.usercenter.data.api

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.data.protocol.BaseResp
import com.shadow.usercenter.data.protocol.LoginReq
import com.shadow.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>
}