package com.shadow.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.shadow.base.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var isShowBack: Boolean = true;
    var titleText: String? = null
    var rightText: String? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText)
        initView()
        typedArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE

        //titleText不为空
        titleText?.let {
            mTitleTv.text = it
        }
        //RightText不为空
        rightText?.let {
            mRightTv.text = it
            mRightTv.visibility = View.VISIBLE
        }

    }
}