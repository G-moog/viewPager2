package com.example.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentViewPager(
    fragmentActivity: FragmentActivity,
    private val fragmentList : List<Fragment>
) : FragmentStateAdapter(fragmentActivity){

    override fun createFragment(position: Int) = fragmentList[position]

    override fun getItemCount(): Int = fragmentList.size
}