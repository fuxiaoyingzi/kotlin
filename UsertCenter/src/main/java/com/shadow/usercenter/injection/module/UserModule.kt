package com.shadow.usercenter.injection.module

import com.shadow.usercenter.service.UserRegister
import com.shadow.usercenter.service.impl.UserRegisterImpl
import dagger.Module
import dagger.Provides

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
@Module
class UserModule {
    @Provides
    fun provideUserServices(userRegister: UserRegisterImpl): UserRegister {
        return userRegister
    }
}