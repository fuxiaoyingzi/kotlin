package com.shadow.usercenter.data.api

import com.shadow.base.data.protocol.BaseResp
import com.shadow.usercenter.data.protocol.RegisterBody
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
    fun register(@Body req: RegisterBody): Observable<BaseResp<String>>
}