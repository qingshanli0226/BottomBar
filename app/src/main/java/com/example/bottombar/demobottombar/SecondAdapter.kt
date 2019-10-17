package com.example.bottombar.demobottombar

import android.view.View

//单布局的列表
class SecondAdapter : BaseAdapter<String, SecondViewHolder>() {
    override fun bindView(viewHolder: SecondViewHolder, dataBean: String, position: Int) {
        viewHolder.textView!!.text = dataBean
    }

    override fun getLayoutId(type: Int): Int {
        return R.layout.second_layout
    }

    override fun getViewHolder(type: Int, rootView: View): SecondViewHolder {
        return SecondViewHolder(rootView)
    }
}