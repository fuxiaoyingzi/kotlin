package com.shadow.usercenter.injection.module

import com.shadow.base.injection.PerComponentScope
import com.shadow.usercenter.service.UploadService
import com.shadow.usercenter.service.UserService
import com.shadow.usercenter.service.impl.UploadServiceImpl
import com.shadow.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Author : shadow
 * Desc : Dagger 注解接口实现
 * Date :2018/6/3/003
 */
@Module
class UserModule {
    @Provides
    @PerComponentScope
    fun provideUserServices(userRegister: UserServiceImpl): UserService {
        return userRegister
    }
    @Provides
    @PerComponentScope
    fun provideUploadServices(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}