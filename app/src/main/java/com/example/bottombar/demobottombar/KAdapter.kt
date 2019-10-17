package com.example.bottombar.demobottombar

import android.view.View

class KAdapter : BaseAdapter<Any, BaseAdapter.BaseKViewHolder>(){

    //子类渲染方法
    //第一个参数是viewholder存放不同view控件的实例。不同的列表元素返回的viewholder类型不同但都是继承BaseViewHloder
    //第二个参数是数据源，不同列表元素对应数据源不同.
    //第三个参数是位置
    override fun bindView(viewHolder: BaseKViewHolder, dataBean: Any,  position: Int) {
        when(position) {
            0-> {
                var k1ViewHolder = viewHolder as K1ViewHolder // 类型强转
                var value = dataBean as String

                k1ViewHolder.textView!!.text = value
            }
            1->{
                var k2ViewHolder = viewHolder as K2ViewHolder
                var k2DataBean = dataBean as K2DataBean

                k2ViewHolder.textView!!.text = k2DataBean.msg
                k2ViewHolder.image!!.setImageResource(k2DataBean.picId)

            }
        }

    }

    //该adapter支持两种布局类型
    private val BANNER_TYPE = 100
    private val RECOMMEND_TYPE = 200


    override fun getViewType(position: Int): Int {
        var type = when(position) {
            0-> BANNER_TYPE // 列表第一个元素，是Banner类型
            1-> RECOMMEND_TYPE //列表第二个元素是推荐类型
            else -> BANNER_TYPE //默认值,用不到
        }
        return type
    }

    //根据不同的布局类型返回不同的布局文件
    override fun getLayoutId(type: Int): Int {
        var layoutId =
        when(type) {
            BANNER_TYPE-> R.layout.item1_layout //列表第一个元素对应的布局文件
            RECOMMEND_TYPE->R.layout.item2_layout//列表第二个元素对应的布局文件
            else -> R.layout.item1_layout
        }
        return layoutId
    }

    //不同的布局返回不同的viewHolder
    override fun getViewHolder(type: Int, rootView: View): BaseKViewHolder {
        var viewHolder = when(type) {
            BANNER_TYPE->K1ViewHolder(rootView) //列表第一个元素对应的viewholder
            RECOMMEND_TYPE->K2ViewHolder(rootView)//列表第二个元素对应的viewholder
            else -> K1ViewHolder(rootView)
        }
        return viewHolder
    }
}