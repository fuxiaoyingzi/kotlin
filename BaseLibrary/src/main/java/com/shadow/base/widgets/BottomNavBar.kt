package com.shadow.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.shadow.base.R

/**
 * Author : shadow
 * Desc : 底部导航栏
 * Date :2018/7/8/008
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {
    var carBadger: TextBadgeItem
    var msgBadge: ShapeBadgeItem

    init {
        //首页
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, R.string.nav_bar_home)
                .setActiveColorResource(R.color.common_blue)
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)
                .setInActiveColorResource(R.color.text_normal)
        //分类
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, R.string.nav_bar_category)
                .setActiveColorResource(R.color.common_blue)
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setInActiveColorResource(R.color.text_normal)
        //购物车
        val carItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, R.string.nav_bar_cart)
                .setActiveColorResource(R.color.common_blue)
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setInActiveColorResource(R.color.text_normal)
        carBadger = TextBadgeItem()
        carItem.setBadgeItem(carBadger)

        //消息中心
        val messageItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, R.string.nav_bar_msg)
                .setActiveColorResource(R.color.common_blue)
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setInActiveColorResource(R.color.text_normal)
        msgBadge = ShapeBadgeItem()
        msgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)
        messageItem.setBadgeItem(msgBadge)

        //个人中心
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, R.string.nav_bar_user)
                .setActiveColorResource(R.color.common_blue)
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setInActiveColorResource(R.color.text_normal)

        addItem(homeItem)
                .addItem(categoryItem)
                .addItem(carItem)
                .addItem(messageItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBarBackgroundColor(R.color.common_white)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise()
    }

    fun setCarCount(count: Int) {
        if (count == 0) {
            carBadger.hide()
        } else {
            carBadger.show()
            carBadger.setText("$count")
        }
    }
    fun setMsgBadge(show: Boolean) {
        if (show) {
            msgBadge.show()
        } else {
            msgBadge.hide()
        }
    }
}