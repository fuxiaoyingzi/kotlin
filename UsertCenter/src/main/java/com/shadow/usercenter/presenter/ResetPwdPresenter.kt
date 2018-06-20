package com.shadow.usercenter.presenter

import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.ResetPwdView
import com.shadow.usercenter.service.UserService
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {
    //同一个接口，两种不同实现的注解，区分使用，限定符named
    @Inject
    lateinit var userRegister: UserService

    fun resetPwd(phoneNum: String, pwd: String) {
        if (!checkNetWork()) {
            mView.closeLoading()
            return@resetPwd
        }
        userRegister.resetPwd(phoneNum, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onResetPwdResult("重置成功")
                        }
                    }
                }, lifecycleProvider)
    }
}