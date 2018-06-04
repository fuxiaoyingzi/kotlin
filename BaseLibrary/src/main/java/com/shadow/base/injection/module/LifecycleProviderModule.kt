package com.shadow.base.injection.module

import com.shadow.base.injection.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
@Module
class LifecycleProviderModule(private val lifeProvider: LifecycleProvider<*>) {
    @Provides
    @ActivityScope
    fun providerLifecycleProvider(): LifecycleProvider<*> {
        return lifeProvider
    }
}