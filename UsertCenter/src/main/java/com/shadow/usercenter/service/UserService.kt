package com.shadow.usercenter.service

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable


/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
interface UserService {
    //注册
    fun register(phoneNum: String, pwd: String, authCode: String): Observable<Boolean>

    //登录
    fun login(phoneNum: String, pwd: String, pushId: String): Observable<UserInfo>

    //忘记密码
    fun forgetPwd(phoneNum: String, authCode: String): Observable<Boolean>

    //重置密码
    fun resetPwd(phoneNum: String, pwd: String): Observable<Boolean>

    //修改用户信息
    fun editUserInfo(userIcon: String, userName: String, userSex: String, userSign: String): Observable<UserInfo>
}