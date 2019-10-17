package com.example.bottombar.demobottombar

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item1_layout.view.*
import kotlinx.android.synthetic.main.item2_layout.view.*

class K2ViewHolder(itemView: View) : BaseAdapter.BaseKViewHolder(itemView) {
    var textView : TextView? = null
    var image : ImageView? = null
    init {
        textView = itemView.text2
        image = itemView.img
    }

}