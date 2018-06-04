package com.shadow.usercenter.presenter

import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.RegisterView
import com.shadow.usercenter.service.UserRegister
import javax.inject.Inject
import javax.inject.Named

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    //同一个接口，两种不同实现的注解，区分使用，限定符named
    @Inject
    @field:[Named("service")]
    lateinit var userRegister: UserRegister

    @Inject
    @field:[Named("service2")]
    lateinit var userRegister2: UserRegister

    fun register(phoneNum: String, pwd: String, authCode: String) {
        userRegister.register(phoneNum, pwd, authCode).execute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.onRegisterResult(t)
            }
        })
    }

    fun register2(phoneNum: String, pwd: String, authCode: String) {
        userRegister2.register(phoneNum, pwd, authCode).execute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.onRegisterResult(t)
            }
        })
    }
}