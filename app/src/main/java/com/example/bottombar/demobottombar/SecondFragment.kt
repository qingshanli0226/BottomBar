package com.example.bottombar.demobottombar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment_second, container, false)

        super.onCreateView(inflater, container, savedInstanceState)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var secondAdapter = SecondAdapter()
        secondRecv.adapter = secondAdapter
        secondRecv.layoutManager = LinearLayoutManager(activity)
        secondAdapter.updateData(mutableListOf("hello", "the", "cruel", "world"))
    }
}