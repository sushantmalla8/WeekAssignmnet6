package com.assignment.esoftwarica.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerAdapter(
    supportFragmentManager: FragmentManager
) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val lstFragments = ArrayList<Fragment>()
    private val lstFragmentTitle = ArrayList<String>();


    override fun getCount(): Int {
        return lstFragments.size;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return lstFragmentTitle[position];
    }

    override fun getItem(position: Int): Fragment {
        return lstFragments[position];
    }

    fun addFragment(fragment: Fragment, title: String) {
        lstFragments.add(fragment);
        lstFragmentTitle.add(title);
    }

}