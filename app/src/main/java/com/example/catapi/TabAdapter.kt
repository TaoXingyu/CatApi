package com.example.catapi

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(private val context: Context, fm: FragmentManager, internal var totalTabs: Int):
   FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when (position){
            //create fragment
            0 -> BreedsFragment()
            else -> ImagesFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}