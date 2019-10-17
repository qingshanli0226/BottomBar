package com.example.bottombar.demobottombar

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item1_layout.view.*

class K1ViewHolder(itemView: View) : BaseAdapter.BaseKViewHolder(itemView) {
    var textView : TextView? = null
    init {
        textView = itemView.text1
    }

}