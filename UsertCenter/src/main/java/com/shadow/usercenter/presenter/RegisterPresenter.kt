package com.shadow.usercenter.presenter

import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.RegisterView
import com.shadow.usercenter.service.UserService
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    //同一个接口，两种不同实现的注解，区分使用，限定符named
    @Inject
    lateinit var userRegister: UserService

    fun register(phoneNum: String, pwd: String, authCode: String) {
        if (!checkNetWork()) {
            mView.closeLoading()
            return@register
        }
        userRegister.register(phoneNum, pwd, authCode)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onRegisterResult("注册成功")
                        }
                    }
                }, lifecycleProvider)
    }
}