package com.shadow.usercenter.service

import rx.Observable


/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
interface UserRegister {
    fun register(phoneNum: String,pwd:String, authCode: String): Observable<Boolean>
}