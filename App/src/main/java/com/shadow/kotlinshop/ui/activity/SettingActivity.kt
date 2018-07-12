package com.shadow.kotlinshop.ui.activity

import android.os.Bundle
import com.kotlin.user.utils.UserPrefsUtils
import com.shadow.base.ui.activity.BaseActivity
import com.shadow.kotlinshop.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        mLogoutBtn.setOnClickListener { //退出登录
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }
}
