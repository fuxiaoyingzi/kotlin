package com.shadow.usercenter.data.repository

import com.shadow.base.data.net.RetrofitFactory
import com.shadow.base.data.protocol.BaseResp
import com.shadow.usercenter.data.api.UserApi
import rx.Observable
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :  服务器和presenter 直接的接口
 * Date :2018/6/3/003
 */
class UploadRepository @Inject constructor() {
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .getUploadToken()
    }
}