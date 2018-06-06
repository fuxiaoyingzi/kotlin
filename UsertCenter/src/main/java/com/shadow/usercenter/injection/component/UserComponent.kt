package com.shadow.usercenter.injection.component

import com.shadow.base.injection.PerComponentScope
import com.shadow.base.injection.component.ActivityComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.ui.activity.ForgetPwdActivity
import com.shadow.usercenter.ui.activity.LoginActivity
import com.shadow.usercenter.ui.activity.RegisterActivity
import com.shadow.usercenter.ui.activity.ResetPwdActivity
import dagger.Component

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = [(UserModule::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
}