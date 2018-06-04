package com.shadow.base.ui.activity

import android.os.Bundle
import com.shadow.base.common.BaseApplication
import com.shadow.base.injection.component.ActivityComponent
import com.shadow.base.injection.component.DaggerActivityComponent
import com.shadow.base.injection.module.ActivityModule
import com.shadow.base.injection.module.LifecycleProviderModule
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    lateinit var activityComponent: ActivityComponent
    override fun showLoading() {
    }

    override fun closeLoading() {
    }

    override fun onError() {
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
    }

    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .activityModule(ActivityModule(this)).build()
    }

}
