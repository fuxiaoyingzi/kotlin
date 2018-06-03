package com.shadow.base.data.protocol

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T)