package com.example.bottombar.demobottombar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomBar.OnBottomTabClickListener {
    private var currentFragment:Fragment? = null

    //初始化四个Frgment
    private var fragments = arrayOf(FirstFragment(), SecondFragment(), ThirdFragment(), FourthFragment())

    override fun onTabClick(tabIndex: Int) {
        switchFragment(tabIndex)
    }

    private fun switchFragment(tabIndex: Int) {
        var fragmentManager = supportFragmentManager
        var fragmentTranction = fragmentManager.beginTransaction()

        var frgment = fragments[tabIndex]


        //判断当前显示的fragment和要切换的Fragment是否是一个，如果不是的话
        if (currentFragment != frgment) {
            fragmentTranction.hide(currentFragment!!) //肯定不为空，因为之前已经设置了默认值

            //如果要切换的fragment没有添加到系统中，首先添加到系统中
            if (!frgment.isAdded) {
                fragmentTranction.add(R.id.framelayout, frgment).commit()
            } else {
                //如果之前已经提交过，则直接显示
                fragmentTranction.show(frgment).commit()
            }
            currentFragment = frgment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomBar.registerBottombarTabClickListener(this)

        var drawableList = listOf<Int>(R.drawable.menu, R.drawable.message_icon, R.drawable.search, R.drawable.settings)
        bottomBar.setAllTabDrawableByCount(drawableList, 3)
        var titleList = listOf<Int>(R.string.menu, R.string.message, R.string.search, R.string.settings)
        bottomBar.setAllTabTextByCount(titleList, 3)


        //默认显示第一个Fragment
        var fragmentManager = supportFragmentManager
        var fragmentTranction = fragmentManager.beginTransaction()
        fragmentTranction.add(R.id.framelayout, fragments[0]).commit()
        currentFragment = fragments[0]
    }
}
