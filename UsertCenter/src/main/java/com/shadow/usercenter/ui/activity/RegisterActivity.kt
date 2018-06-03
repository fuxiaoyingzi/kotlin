package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.shadow.base.ui.activity.BaseMvpActivity
import com.shadow.usercenter.R
import com.shadow.usercenter.presenter.RegisterPresenter
import com.shadow.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        registerBtn.setOnClickListener {
            mPresenter.register(etPhoneNum.text.toString(), etPwd.text.toString(), etAuthCode.text.toString())
        }

    }
}
