package com.shadow.usercenter.injection.component

import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
@Component(modules = [(UserModule::class)])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}