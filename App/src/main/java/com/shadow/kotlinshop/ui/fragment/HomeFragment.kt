package com.shadow.kotlinshop.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mall.common.HOME_BANNER_FOUR
import com.kotlin.mall.common.HOME_BANNER_ONE
import com.kotlin.mall.common.HOME_BANNER_THREE
import com.kotlin.mall.common.HOME_BANNER_TWO
import com.shadow.base.widgets.GlideImageLoader
import com.shadow.kotlinshop.R
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Author : shadow
 * Desc : 首页
 * Date :2018/7/9/009
 */
class HomeFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_home, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        mNewsFlipperView.setData(arrayOf("hello shadow1","hello shadow2","hello shadow3","hello shadow4"))
    }

    private fun initBanner() {
        mBanner.setImageLoader(GlideImageLoader())
        mBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mBanner.setBannerAnimation(Transformer.DepthPage)
        //设置轮播时间
        mBanner.setDelayTime(1500)
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER)
        //banner设置方法全部调用完毕时最后调用
        mBanner.start()

    }

    override fun onStart() {
        super.onStart()
        //开始轮播
        mBanner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        //结束轮播
        mBanner.stopAutoPlay();
    }
}