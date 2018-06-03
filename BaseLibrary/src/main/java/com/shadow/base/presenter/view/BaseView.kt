package com.shadow.base.presenter.view

/**
 * Author : shadow
 * Desc : mvp view 基类
 * Date :2018/6/3/003
 */
interface BaseView {
    fun showLoading()
    fun closeLoading()
    fun onError()
}