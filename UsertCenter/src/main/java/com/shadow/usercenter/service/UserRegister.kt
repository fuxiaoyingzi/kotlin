package com.shadow.usercenter.service

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable


/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
interface UserRegister {
    fun register(phoneNum: String,pwd:String, authCode: String): Observable<Boolean>
    fun login(phoneNum: String, pwd: String, pushId: String): Observable<UserInfo>
    fun forgetPwd(phoneNum: String, authCode: String): Observable<Boolean>
    fun resetPwd(phoneNum: String, pwd: String): Observable<Boolean>
}