package com.shadow.kotlinshop.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.shadow.base.ui.activity.BaseActivity
import com.shadow.kotlinshop.R
import com.shadow.kotlinshop.ui.fragment.HomeFragment
import com.shadow.kotlinshop.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { MineFragment() }
    private val mCartFragment by lazy { HomeFragment() }
    private val mMsgFragment by lazy { MineFragment() }
    private val mMineFragment by lazy { MineFragment() }
    private val mStack = Stack<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavBar.setMsgBadge(true)
        bottomNavBar.setCarCount(10)
        initFragment()
        initBottomNavBar()
        changeFragment(0)
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.container, HomeFragment())
        manager.commit()
    }

    // 初始化Fragment栈管理
    private fun initFragment(){
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.container,  mHomeFragment)
        manager.add(R.id.container,  mCategoryFragment)
        manager.add(R.id.container,  mCartFragment)
        manager.add(R.id.container,  mMsgFragment)
        manager.add(R.id.container,  mMineFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMineFragment)

    }

    //初始化底部导航切换事件
    private fun initBottomNavBar(){
        bottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }

    // 切换Tab，切换对应的Fragment
    private fun changeFragment(position:Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (i in mStack){
           manager.hide(i)
        }
        manager.show(mStack[position])
        manager.commit()
    }

}
