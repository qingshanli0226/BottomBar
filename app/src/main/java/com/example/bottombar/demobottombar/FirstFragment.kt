package com.example.bottombar.demobottombar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_first, container, false)

        super.onCreateView(inflater, container, savedInstanceState)


        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var kAdapter = KAdapter()
        recylerview.layoutManager = LinearLayoutManager(activity)
        recylerview.adapter = kAdapter

        //初始化数据
        var beanList = mutableListOf<Any>("BANNER", K2DataBean("RECOMMEND", R.drawable.menu))

        //给adapter更新数据
        kAdapter.updateData(beanList)
    }
}