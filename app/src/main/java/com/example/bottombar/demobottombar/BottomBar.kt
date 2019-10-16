package com.example.bottombar.demobottombar

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View

import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.view_bottombar.view.*

class BottomBar @JvmOverloads constructor(ctx:Context, attrs:AttributeSet? = null, defStyle:Int = 0) : LinearLayout(ctx, attrs, defStyle) {

    private var tabClickListener:OnBottomTabClickListener? = null
    private var color:Int = 0

    init {

        var typeArray = context.obtainStyledAttributes(attrs, R.styleable.BottomBar)
        color = typeArray.getColor(R.styleable.BottomBar_selectColor, Color.WHITE)

        var inflater = LayoutInflater.from(ctx)
        inflater.inflate(R.layout.view_bottombar, this)

        bottomGroup.setOnCheckedChangeListener { group, checkedId ->
            var tabIndex =
            when(checkedId) {
                R.id.home -> {
                    home.setBackgroundColor(color)
                    type.setBackgroundColor(Color.GRAY)
                    shoppingCar.setBackgroundColor(Color.GRAY)
                    mine.setBackgroundColor(Color.GRAY)
                    0
                }
                R.id.type -> {
                    home.setBackgroundColor(Color.GRAY)
                    type.setBackgroundColor(color)
                    shoppingCar.setBackgroundColor(Color.GRAY)
                    mine.setBackgroundColor(Color.GRAY)
                    1
                }
                R.id.shoppingCar ->  {
                    home.setBackgroundColor(Color.GRAY)
                    type.setBackgroundColor(Color.GRAY)
                    shoppingCar.setBackgroundColor(color)
                    mine.setBackgroundColor(Color.GRAY)
                    2
                }
                R.id.mine ->  {
                    home.setBackgroundColor(Color.GRAY)
                    type.setBackgroundColor(Color.GRAY)
                    shoppingCar.setBackgroundColor(Color.GRAY)
                    mine.setBackgroundColor(color)
                    3
                }
                else -> -1
            }
            if (tabClickListener == null) {

            } else {
                tabClickListener!!.onTabClick(tabIndex)
            }
        }

    }

    //修改第一RadioButton的图片
    fun setFirstTabDrawable(@DrawableRes drawableId:Int) {
        home.setButtonDrawable(drawableId)
    }
    //修改第一RadioButton的文字
    fun setFirstTabText(@StringRes stringId:Int) {
        home.setText(stringId)
    }

    //列表的Int为DrawableRes
    fun setAllTabDrawable(drawableAllIds:List<Int>) {
        home.setButtonDrawable(drawableAllIds.get(0))
        type.setButtonDrawable(drawableAllIds.get(1))
        shoppingCar.setButtonDrawable(drawableAllIds.get(2))
        mine.setButtonDrawable(drawableAllIds.get(3))
    }

    //StringRes
    fun setAllTabText(stringAllIds:List<Int>) {
        home.setText(stringAllIds.get(0))
        type.setText(stringAllIds.get(1))
        shoppingCar.setText(stringAllIds.get(2))
        mine.setText(stringAllIds.get(3))
    }

    //StringRes
    fun setAllTabTextByCount(stringAllIds:List<Int>, count:Int) {
        when (count) {
            4 -> {
                home.setText(stringAllIds.get(0))
                type.setText(stringAllIds.get(1))
                shoppingCar.setText(stringAllIds.get(2))
                mine.setText(stringAllIds.get(3))
            }

            3-> {
                home.setText(stringAllIds.get(0))
                type.setText(stringAllIds.get(1))
                shoppingCar.setText(stringAllIds.get(2))
            }

            2-> {
                home.setText(stringAllIds.get(0))
                type.setText(stringAllIds.get(1))
            }

            1-> {
                home.setText(stringAllIds.get(0))
            }
            else -> {
                Toast.makeText(context, "数量不能大于4个", Toast.LENGTH_SHORT).show()
            }
        }


        setTabCount(count)
    }

    //列表的Int为DrawableRes
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setAllTabDrawableByCount(drawableAllIds:List<Int>, count:Int) {
        when (count) {
            4 -> {
                var drawableFirst = context.getDrawable(drawableAllIds.get(0))
                drawableFirst.setBounds(0, 10, 50, 50)
                home.setCompoundDrawables(null,drawableFirst,null,null)

                var drawableSecond = context.getDrawable(drawableAllIds.get(1))
                drawableSecond.setBounds(0, 10, 50, 50)
                type.setCompoundDrawables(null,drawableSecond,null,null)

                var drawableThird = context.getDrawable(drawableAllIds.get(2))
                drawableThird.setBounds(0, 10, 50, 50)
                shoppingCar.setCompoundDrawables(null,drawableThird,null,null)

                var drawableFourth = context.getDrawable(drawableAllIds.get(3))
                drawableFourth.setBounds(0, 10, 50, 50)
                mine.setCompoundDrawables(null,drawableFourth,null,null)
            }

            3-> {
                var drawableFirst = context.getDrawable(drawableAllIds.get(0))
                drawableFirst.setBounds(0, 10, 50, 50)
                home.setCompoundDrawables(null,drawableFirst,null,null)

                var drawableSecond = context.getDrawable(drawableAllIds.get(1))
                drawableSecond.setBounds(0, 10, 50, 50)
                type.setCompoundDrawables(null,drawableSecond,null,null)

                var drawableThird = context.getDrawable(drawableAllIds.get(2))
                drawableThird.setBounds(0, 10, 50, 50)
                shoppingCar.setCompoundDrawables(null,drawableThird,null,null)
            }

            2-> {
                var drawableFirst = context.getDrawable(drawableAllIds.get(0))
                drawableFirst.setBounds(0, 10, 50, 50)
                home.setCompoundDrawables(null,drawableFirst,null,null)

                var drawableSecond = context.getDrawable(drawableAllIds.get(1))
                drawableSecond.setBounds(0, 10, 50, 50)
                type.setCompoundDrawables(null,drawableSecond,null,null)
            }

            1-> {
                var drawableFirst = context.getDrawable(drawableAllIds.get(0))
                drawableFirst.setBounds(0, 10, 50, 50)
                home.setCompoundDrawables(null,drawableFirst,null,null)
            }
            else -> {
                Toast.makeText(context, "数量不能大于4个", Toast.LENGTH_SHORT).show()
            }
        }


        setTabCount(count)
    }

    //可以修改tab的数量
    fun setTabCount(num:Int) {
        if (num > 4) {
            Toast.makeText(context, "数量不能大于4个", Toast.LENGTH_SHORT).show()
            return
        } else {
            when(num) {
                3-> mine.visibility = View.GONE
                2->  {
                    mine.visibility = View.GONE
                    shoppingCar.visibility = View.GONE
                }
                1-> {
                    mine.visibility = View.GONE
                    shoppingCar.visibility = View.GONE
                    type.visibility = View.GONE
                }

            }
        }
    }

    fun registerBottombarTabClickListener(listener:OnBottomTabClickListener?) {
        this.tabClickListener = listener
    }

    interface OnBottomTabClickListener {
        //tabIndex from 0 ~ 3
        fun onTabClick(tabIndex:Int)
    }

}