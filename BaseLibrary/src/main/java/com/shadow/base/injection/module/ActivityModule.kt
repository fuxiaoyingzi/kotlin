package com.shadow.base.injection.module

import android.app.Activity
import com.shadow.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
/*@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @ActivityScope
    fun providerActivity(): Activity {
        return activity
    }
}*/


/*
    Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}