package com.shadow.provider.common

import com.kotlin.base.utils.AppPrefsUtils
import com.shadow.base.common.BaseConstants

/**
 * Author : shadow
 * Desc :
 * Date :2018/7/12/012
 */
//是否已经登录 true 已经登录 false 未登录
fun isLogin() :Boolean{
    return !AppPrefsUtils.getString(BaseConstants.KEY_SP_TOKEN).isEmpty()
}