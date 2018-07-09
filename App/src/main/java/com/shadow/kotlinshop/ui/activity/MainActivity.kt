package com.shadow.kotlinshop.ui.activity

import android.os.Bundle
import com.shadow.base.ui.activity.BaseActivity
import com.shadow.kotlinshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavBar.setMsgBadge(true)
        bottomNavBar.setCarCount(10)
    }

}
