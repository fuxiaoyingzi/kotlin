package com.shadow.base.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope