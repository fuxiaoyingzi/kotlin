package com.shadow.base.common

import android.app.Application
import com.shadow.base.injection.component.AppComponent
import com.shadow.base.injection.component.DaggerAppComponent
import com.shadow.base.injection.module.AppModule
import kotlin.properties.Delegates

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
class BaseApplication : Application() {
    lateinit var appComponent: AppComponent;
    override fun onCreate() {
        super.onCreate()
        initInjection()
        instance = this
    }

    /**
     * 初始化全局 component
     */
    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        var instance: BaseApplication by Delegates.notNull()

    }
}