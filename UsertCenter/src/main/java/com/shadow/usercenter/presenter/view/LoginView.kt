package com.shadow.usercenter.presenter.view

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.presenter.view.BaseView

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}