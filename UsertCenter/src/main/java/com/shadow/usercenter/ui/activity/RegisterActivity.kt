package com.shadow.usercenter.ui.activity

import android.os.Bundle
import com.shadow.base.common.AppManager
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
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerBtn.onclick {
            showLoading()
            mPresenter.register(etPhoneNum.text.toString(), etPwd.text.toString(), etAuthCode.text.toString())
        }
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


}
