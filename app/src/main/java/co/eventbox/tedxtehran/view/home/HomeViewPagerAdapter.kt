package co.eventbox.tedxtehran.view.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import co.eventbox.tedxtehran.view.home.speakers.MainEventSpeakersFragment
import co.eventbox.tedxtehran.view.home.timeSchedule.TimeScheduleFragment

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/18/20.
 */
class HomeViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = mutableListOf(
        MainEventSpeakersFragment(),
        TimeScheduleFragment(),
        HomeFragment()
    )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}