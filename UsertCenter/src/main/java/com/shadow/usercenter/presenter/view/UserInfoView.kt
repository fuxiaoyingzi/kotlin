package com.shadow.usercenter.presenter.view

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.presenter.view.BaseView

/**
 * Author : shadow
 * Desc : 用户信息修改
 * Date :2018/6/3/003
 */
interface UserInfoView : BaseView {
    //获取七牛云上传图片凭证
    fun onGetUploadToken(result: String)

    //修改用户信息
    fun onEditUser(result: UserInfo)

}