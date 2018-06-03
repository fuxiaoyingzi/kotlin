package com.shadow.usercenter.presenter

import com.shadow.base.presenter.BasePresenter
import com.shadow.usercenter.presenter.view.RegisterView

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(phoneNum: String, authCode: String) {
        /**
         * 业务处理
         */
        mView.onRegisterResult(true)
    }
}