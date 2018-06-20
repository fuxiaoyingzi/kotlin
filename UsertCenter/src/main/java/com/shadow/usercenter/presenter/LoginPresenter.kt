package com.shadow.usercenter.presenter

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.LoginView
import com.shadow.usercenter.service.UserService
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userLogin: UserService

    fun login(phoneNum: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            mView.closeLoading()
            return@login
        }

        userLogin.login(phoneNum, pwd, pushId)
                .execute(object : BaseSubscriber<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResult(t)
                    }
                }, lifecycleProvider)
    }
}