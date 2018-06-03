package com.shadow.usercenter.presenter

import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.RegisterView
import com.shadow.usercenter.service.impl.UserRegisterImpl

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(phoneNum: String, authCode: String) {
        val userRegister = UserRegisterImpl()
        /**
         * 业务处理
         */
        userRegister.register(phoneNum, authCode).execute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.onRegisterResult(t)
            }
        })
    }
}