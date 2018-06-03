package com.shadow.base.presenter

import com.shadow.base.presenter.view.BaseView

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}