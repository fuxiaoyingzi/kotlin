package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.user.data.protocol.UserInfo
import com.shadow.base.ext.enable
import com.shadow.base.ext.onclick
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.injection.component.DaggerUserComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.presenter.LoginPresenter
import com.shadow.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 登录界面
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        /**
         * 监听事件扩展，确定是否所有的et都有值，让注册按钮可点击
         */
        mLoginBtn.enable(mMobileEt, { btnIsEnable() })
        mLoginBtn.enable(mPwdEt, { btnIsEnable() })

        //注册
        mLoginBtn.onclick {
            showLoading()
            mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
        }

        //注册
        mHeaderBar.getRightView().onclick {
            startActivity<RegisterActivity>()
        }
    }

    /**
     * 判断editView的值是否为空
     */
    private fun btnIsEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() && mPwdEt.text.isNullOrEmpty().not()
    }

    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

}
