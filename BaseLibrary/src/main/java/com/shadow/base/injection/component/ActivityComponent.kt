package com.shadow.base.injection.component

import android.app.Activity
import android.content.Context
import com.shadow.base.injection.ActivityScope
import com.shadow.base.injection.module.ActivityModule
import com.shadow.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {
    fun activity(): Activity
    fun lifecycleProvider(): LifecycleProvider<*>
    fun context(): Context
}