package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.utils.UserPrefsUtils
import com.shadow.base.common.AppManager
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
    private var pressTime: Long = 0
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

        //登录
        mLoginBtn.onclick {
            showLoading()
            mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
        }

        //注册
        mHeaderBar.getRightView().onclick {
            startActivity<RegisterActivity>()
        }

        //忘记密码
        mForgetPwdTv.onclick {
            startActivity<ForgetPwdActivity>()
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
        UserPrefsUtils.putUserInfo(result)
        finish()
        //startActivity<UserInfoActivity>()
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    //再按一次退出程序
    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }

    }

}
