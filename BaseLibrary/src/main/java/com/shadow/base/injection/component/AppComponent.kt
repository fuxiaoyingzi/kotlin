package com.shadow.base.injection.component

import android.content.Context
import com.shadow.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Author : shadow
 * Desc : 全局的component
 * Date :2018/6/4/004
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context

}