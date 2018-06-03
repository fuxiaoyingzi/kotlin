package com.shadow.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shadow.usercenter.R
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerBtn.setOnClickListener {
            toast("hello shadow")
        }
        startActivity<TestActivity>("id" to 10)
//        startActivity(intentFor<TestActivity>("id" to 10))
    }
}
