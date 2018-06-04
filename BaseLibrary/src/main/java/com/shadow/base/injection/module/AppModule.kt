package com.shadow.base.injection.module

import android.content.Context
import com.shadow.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Author : shadow
 * Desc : 全局级别的module
 * Date :2018/6/4/004
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Provides
    @Singleton
    fun providerContext():Context{
        return context
    }
}