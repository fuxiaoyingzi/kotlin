package com.shadow.usercenter.data.api

import com.kotlin.user.data.protocol.EditUserReq
import com.kotlin.user.data.protocol.ForgetPwdReq
import com.kotlin.user.data.protocol.ResetPwdReq
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

    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq): Observable<BaseResp<UserInfo>>

    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq): Observable<BaseResp<UserInfo>>

    /*
       获取七牛云上传凭证
    */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>

    /*
      编辑用户资料
   */
    @POST("userCenter/editUser")
    fun editUser(@Body req:EditUserReq):Observable<BaseResp<UserInfo>>
}