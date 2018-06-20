package com.shadow.usercenter.presenter

import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.ext.execute
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.rx.BaseSubscriber
import com.shadow.usercenter.presenter.view.UserInfoView
import com.shadow.usercenter.service.impl.UploadServiceImpl
import com.shadow.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var uploadService: UploadServiceImpl
    @Inject
    lateinit var userRegister: UserServiceImpl


    /**
     * 获取上传七牛云的token 凭证
     */
    fun getUploadToken() {
        if (!checkNetWork()) {
            mView.closeLoading()
            return
        }
        uploadService.getUploadToken()
                .execute(object : BaseSubscriber<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onGetUploadToken(t)
                    }
                }, lifecycleProvider)
    }

    /**
     * 修改用户信息
     */
    fun editUserInfo(userIcon: String, userName: String, userSex: String, userSign: String) {
        if (!checkNetWork()) {
            mView.closeLoading()
            return
        }
        userRegister.editUserInfo(userIcon, userName, userSex, userSign)
                .execute(object : BaseSubscriber<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onEditUser(t)
                    }
                }, lifecycleProvider)

    }

}