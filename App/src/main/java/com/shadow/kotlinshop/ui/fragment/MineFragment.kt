package com.shadow.kotlinshop.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kotlin.mall.common.*
import com.kotlin.mall.ui.adapter.TopicAdapter
import com.shadow.base.widgets.GlideImageLoader
import com.shadow.kotlinshop.R
import com.shadow.kotlinshop.ui.adapter.HomeDiscountAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow

/**
 * Author : shadow
 * Desc : 我的
 * Date :2018/7/9/009
 */
class MineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)
    }
}