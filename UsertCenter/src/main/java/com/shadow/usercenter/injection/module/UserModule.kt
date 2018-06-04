package com.shadow.usercenter.injection.module

import com.shadow.base.injection.PerComponentScope
import com.shadow.usercenter.service.UserRegister
import com.shadow.usercenter.service.impl.UserRegisterImpl
import com.shadow.usercenter.service.impl.UserRegisterImpl2
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
    @Named("service")
    fun provideUserServices(userRegister: UserRegisterImpl): UserRegister {
        return userRegister
    }

    @Provides
    @PerComponentScope
    @Named("service2")
    fun provideUserServices2(userRegister: UserRegisterImpl2): UserRegister {
        return userRegister
    }
}