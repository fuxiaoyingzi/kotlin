package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.shadow.base.common.AppManager
import com.shadow.base.ext.enable
import com.shadow.base.ext.onclick
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.injection.component.DaggerUserComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.presenter.ResetPwdPresenter
import com.shadow.usercenter.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.*

/**
 * 重置密码
 */
class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView {

    private lateinit var phoneNumber: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)
        initView()
    }

    private fun initView() {
        phoneNumber = intent.getStringExtra("phoneNum")
        /**
         * 监听事件扩展，确定是否所有的et都有值，让注册按钮可点击
         */
        mConfirmBtn.enable(mPwdEt, { btnIsEnable() })
        mConfirmBtn.enable(mPwdConfirmEt, { btnIsEnable() })

        //注册
        mConfirmBtn.onclick {
            showLoading()
            mPresenter.resetPwd(phoneNumber,mPwdEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 重置密码回调
     */
    override fun onResetPwdResult(result: String) {
        toast(result)
        //startActivity<LoginActivity>()
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }


    /**
     * 判断editView的值是否为空
     */
    private fun btnIsEnable(): Boolean {
        return mPwdEt.text.isNullOrEmpty().not() && mPwdConfirmEt.text.isNullOrEmpty().not()
    }


}
