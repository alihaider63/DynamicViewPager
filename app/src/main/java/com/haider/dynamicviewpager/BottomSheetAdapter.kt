package com.haider.dynamicviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class BottomSheetAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = mutableListOf<Fragment>()
    private val tabTitles = mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        tabTitles.add(title)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]

    }
}