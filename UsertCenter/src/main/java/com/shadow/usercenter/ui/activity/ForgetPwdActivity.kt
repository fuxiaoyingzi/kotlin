package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.shadow.base.common.AppManager
import com.shadow.base.ext.enable
import com.shadow.base.ext.onclick
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.injection.component.DaggerUserComponent
import com.shadow.usercenter.injection.module.UserModule
import com.shadow.usercenter.presenter.ForgetPwdPresenter
import com.shadow.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 忘记密码
 */
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()
    }

    private fun initView() {
        /**
         * 监听事件扩展，确定是否所有的et都有值，让注册按钮可点击
         */
        mNextBtn.enable(mMobileEt, { btnIsEnable() })
        mNextBtn.enable(mVerifyCodeEt, { btnIsEnable() })

        //发送验证码
        mVerifyCodeBtn.onclick {
            mVerifyCodeBtn.requestSendVerifyNumber()
            toast("发送验证码成功")
        }
        //下一步
        mNextBtn.onclick {
            showLoading()
            mPresenter.forgetPwd(mMobileEt.text.toString(),  mVerifyCodeEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 忘记密码验证回调
     */
    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>("phoneNum" to mMobileEt.text.toString())
    }


    /**
     * 判断editView的值是否为空
     */
    private fun btnIsEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() && mVerifyCodeEt.text.isNullOrEmpty().not()
    }


}
