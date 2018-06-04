package com.shadow.base.injection.module

import android.app.Activity
import com.shadow.base.injection.ActivityScope
import com.shadow.base.ui.activity.BaseActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @ActivityScope
    fun providerActivity(): Activity {
        return activity
    }
}