package com.example.bottombar.demobottombar

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//兼容不同的数据类型和不同的ItemView 数据的类型为泛型T，itemview的ViewHolder为V
abstract class BaseAdapter<T, V : BaseAdapter.BaseKViewHolder> : RecyclerView.Adapter<V> (){

    private var dataList:MutableList<T> = mutableListOf()//管理的数据

    //更新数据
    fun updateData(beanList:MutableList<T>) {
        dataList.clear()
        dataList.addAll(beanList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    //子类可以重写
    open fun getViewType(position:Int): Int {
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        var type = getViewType(position)
        return type
    }

    //渲染也是由子类来实现
    abstract fun bindView(viewHolder:V, dataBean:T, position: Int)

    override fun onBindViewHolder(viewHolder: V, position: Int) {
        bindView(viewHolder, dataList.get(position), position)
    }

    abstract fun getLayoutId(type:Int):Int

    override fun onCreateViewHolder(p0: ViewGroup, type: Int): V {
        var layoutId = getLayoutId(type)//由子类来指定不同的layout
        var rootView = LayoutInflater.from(p0.context).inflate(layoutId, p0, false)

        return getViewHolder(type, rootView)
    }

    //让子类来返回一个具体的viewholder
    abstract fun getViewHolder(type:Int, rootView:View):V

    open class BaseKViewHolder(var itemView:View) : RecyclerView.ViewHolder(itemView) {
    }
}