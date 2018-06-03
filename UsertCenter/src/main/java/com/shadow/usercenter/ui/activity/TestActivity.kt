package com.shadow.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.shadow.usercenter.R
import org.jetbrains.anko.toast

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        toast("${intent.getIntExtra("id", -1)}")
    }
}
