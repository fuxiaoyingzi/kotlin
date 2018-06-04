package com.shadow.base.ui.activity

import android.os.Bundle
import com.shadow.base.common.BaseApplication
import com.shadow.base.injection.component.ActivityComponent
import com.shadow.base.injection.component.DaggerActivityComponent
import com.shadow.base.injection.module.ActivityModule
import com.shadow.base.injection.module.LifecycleProviderModule
import com.shadow.base.presenter.BasePresenter
import com.shadow.base.presenter.view.BaseView
import com.shadow.base.utils.ToastUtil
import com.shadow.base.widgets.ProgressDialog
import javax.inject.Inject

open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    lateinit var activityComponent: ActivityComponent
    private lateinit var mProgressDialog: ProgressDialog
    override fun showLoading() {
        mProgressDialog.show()
    }

    override fun closeLoading() {
        mProgressDialog.dismiss()
    }

    override fun onError(string: String) {
        ToastUtil.showMsg(string)
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
        mProgressDialog = ProgressDialog.create(this)
    }

    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .activityModule(ActivityModule(this)).build()
    }

    abstract fun injectComponent()

}
