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
 * Desc : 首页
 * Date :2018/7/9/009
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        mNewsFlipperView.setData(arrayOf("hello shadow1", "hello shadow2", "hello shadow3", "hello shadow4"))
        initDiscount()
        initTopic()
    }

    //初始化banner
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

    //初始化折扣
    private fun initDiscount() {
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayout.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager
        val discountAdapter = HomeDiscountAdapter(activity!!)
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
        mHomeDiscountRv.adapter = discountAdapter
    }

    //初始化主题 画廊效果
    private fun initTopic() {
        //话题
        mTopicPager.adapter = TopicAdapter(context!!, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5
        CoverFlow.Builder()
                .with(mTopicPager)
                .scale(0.3f)
                .pagerMargin(-30.0f)
                .spaceSize(0.0f)
                .build()
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