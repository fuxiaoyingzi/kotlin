package com.shadow.base.injection.component

import android.app.Activity
import com.shadow.base.injection.ActivityScope
import com.shadow.base.injection.module.ActivityModule
import dagger.Component

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity(): Activity
}