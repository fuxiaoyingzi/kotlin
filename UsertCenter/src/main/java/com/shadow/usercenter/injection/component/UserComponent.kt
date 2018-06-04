package com.shadow.usercenter.injection.component

import com.shadow.base.injection.PerComponentScope
import com.shadow.base.injection.component.ActivityComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.ui.activity.RegisterActivity
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
}