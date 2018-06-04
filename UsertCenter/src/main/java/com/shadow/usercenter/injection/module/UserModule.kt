package com.shadow.usercenter.injection.module

import com.shadow.base.injection.PerComponentScope
import com.shadow.usercenter.service.UserRegister
import com.shadow.usercenter.service.impl.UserRegisterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
@Module
class UserModule {
    @Provides
    @PerComponentScope
    fun provideUserServices(userRegister: UserRegisterImpl): UserRegister {
        return userRegister
    }
}