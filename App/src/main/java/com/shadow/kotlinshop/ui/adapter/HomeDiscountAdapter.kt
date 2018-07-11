package com.shadow.kotlinshop.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import com.shadow.base.widgets.GlideImageLoader
import com.shadow.kotlinshop.R
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.layout_home_discount_item.view.*

/**
 * Author : shadow
 * Desc : 首页 折扣模块 适配器
 * Date :2018/7/11/011
 */
class HomeDiscountAdapter(context: Context) :BaseRecyclerViewAdapter<String,HomeDiscountAdapter.DiscountViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val  view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_discount_item,parent,false)
        return DiscountViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        GlideUtils.loadImage(mContext, dataList[position],holder.itemView.mGoodsIconIv)
        holder.itemView.mDiscountAfterTv.text = "￥521"
        holder.itemView.mDiscountBeforeTv.text = "￥2048"
    }

    class DiscountViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.mDiscountBeforeTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            view.mDiscountBeforeTv.paint.isAntiAlias = true
        }
    }
}