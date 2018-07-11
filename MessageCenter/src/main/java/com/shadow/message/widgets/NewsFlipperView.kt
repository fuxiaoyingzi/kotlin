package com.shadow.message.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.ViewFlipper
import com.android.shadow.messagecenter.R

/**
 * Author : shadow
 * Desc : 首页 公告
 * Date :2018/7/9/009
 */
class NewsFlipperView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    /**
     * setInAnimation 设置View进入屏幕时候使用的动画
     * setOutAnimation 设置View退出屏幕时候使用的动画
     * showPrevious 显示ViewFlipper里面的上一个View showNext 显示ViewFlipper里面的下一个View
     * setFlipInterval 设置View之间切换的时间间隔
     * startFlipping 使用setFlipInterval方法设置的时间间隔来开始切换所有的View,切换会循环进行
     * stopFlipping 停止View切换
     * isFlipping 用来判断View切换是否正在进行
     * setDisplayedChild 切换到指定子View
     */
     var mFlipperView: ViewFlipper

    init {
        val rootView = View.inflate(context, R.layout.layout_news_flipper, null)
        mFlipperView = rootView.findViewById(R.id.mFlipperView)
        mFlipperView.setInAnimation(context, R.anim.news_bottom_in)
        mFlipperView.setOutAnimation(context, R.anim.news_bottom_out)
        mFlipperView.setFlipInterval(2000)
        addView(rootView)
    }

    private fun buildNewsView(text: String): TextView {
        val textView = TextView(context)
        textView.text = text
        textView.textSize = 18f
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        return textView
    }

    /*
      设置公告数据
   */
    fun setData(data: Array<String>) {
        for (text in data) {
            mFlipperView.addView(buildNewsView(text))
        }
        mFlipperView.startFlipping()
    }
}