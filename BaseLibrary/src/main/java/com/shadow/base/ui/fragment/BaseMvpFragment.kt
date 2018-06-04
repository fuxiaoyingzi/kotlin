package com.shadow.base.ui.fragment

import android.app.Activity
import android.os.Bundle
import com.shadow.base.common.BaseApplication
import com.shadow.base.injection.component.ActivityComponent
import com.shadow.base.injection.component.DaggerActivityComponent
import com.shadow.base.injection.module.ActivityModule
import com.shadow.base.injection.module.LifecycleProviderModule
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.presenter.view.BaseView
import com.shadow.base.utils.ToastUtil
import javax.inject.Inject

open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {
    lateinit var activityComponent: ActivityComponent
    override fun showLoading() {
    }

    override fun closeLoading() {
    }

    override fun onError(string: String) {
        ToastUtil.showMsg(string)
    }


    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        initInjection()
    }

    //初始化module级别 component
    abstract fun injectComponent()

    /**
     * 初始化activity级别的component
     */
    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .activityModule(ActivityModule(activity as Activity)).build()
    }

}
