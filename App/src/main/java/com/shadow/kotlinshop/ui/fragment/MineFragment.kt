package com.shadow.kotlinshop.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import com.shadow.base.ext.loadUrl
import com.shadow.kotlinshop.R
import com.shadow.kotlinshop.ui.activity.SettingActivity
import com.shadow.provider.common.isLogin
import com.shadow.usercenter.ui.activity.LoginActivity
import com.shadow.usercenter.ui.activity.UserInfoActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Author : shadow
 * Desc : 我的
 * Date :2018/7/9/009
 */
class MineFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    //初始化view 监听事件
    private fun initView() {
        mUserIconIv.setOnClickListener(this)
        mUserNameTv.setOnClickListener(this)
        mSettingTv.setOnClickListener(this)
    }


    override fun onStart() {
        super.onStart()
        updateUserInfo()
    }

    //更新用户信息
    private fun updateUserInfo() {
        if (isLogin()) { //登录
            val userIconUrl = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIconUrl.isEmpty()) {
                mUserIconIv.setImageResource(R.drawable.icon_default_user)
            } else {
                mUserIconIv.loadUrl(userIconUrl)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        } else { //未登录
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = resources.getString(R.string.un_login_text)
        }
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> { //登录 or 修改用户信息
                if (isLogin()) {//已经登录，修改用户信息
                    startActivity<UserInfoActivity>()
                } else {//去登陆
                    startActivity<LoginActivity>()
                }
            }

            R.id.mSettingTv -> { //设置
                startActivity<SettingActivity>()
            }
        }

    }
}