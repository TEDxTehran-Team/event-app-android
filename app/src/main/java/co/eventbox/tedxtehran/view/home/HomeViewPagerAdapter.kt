package co.eventbox.tedxtehran.view.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/18/20.
 */
class HomeViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = mutableListOf(
        TimeScheduleFragment(),
        HomeFragment()
    )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}