package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.shadow.base.common.AppManager
import com.shadow.base.ext.enable
import com.shadow.base.ext.onclick
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.injection.component.DaggerUserComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.presenter.RegisterPresenter
import com.shadow.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        /**
         * 监听事件扩展，确定是否所有的et都有值，让注册按钮可点击
         */
        mRegisterBtn.enable(mMobileEt, { btnIsEnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { btnIsEnable() })
        mRegisterBtn.enable(mPwdEt, { btnIsEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { btnIsEnable() })

        //发送验证码
        mVerifyCodeBtn.onclick {
            mVerifyCodeBtn.requestSendVerifyNumber()
            toast("发送验证码成功")
        }
        //注册
        mRegisterBtn.onclick {
            showLoading()
            mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    //注册回调
    override fun onRegisterResult(result: String) {
        toast(result)
    }


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }

    }

    /**
     * 判断editView的值是否为空
     */
    private fun btnIsEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() && mVerifyCodeEt.text.isNullOrEmpty().not()
                && mPwdEt.text.isNullOrEmpty().not() && mPwdConfirmEt.text.isNullOrEmpty().not()
    }


}
