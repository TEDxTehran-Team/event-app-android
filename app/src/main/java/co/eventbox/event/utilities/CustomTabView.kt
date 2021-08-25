package co.eventbox.event.utilities

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


/* custom and simple tablayout class
*  write by mahdidrv.ir
* */


class CustomTabView(
    activity: FragmentActivity,
    fragmentManager: FragmentManager,
    @IdRes tabLayoutId: Int,
    @IdRes viewPagerId: Int
) {


    private val tabLayout: TabLayout
    private val viewPager: ViewPager
    private val adapter: Adapter

    init {
        val rootView = activity.window.decorView
        tabLayout = rootView.findViewById(tabLayoutId)
        viewPager = rootView.findViewById(viewPagerId)

        adapter = Adapter(fragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

    fun add(fragmentClass: Class<out Fragment>, title: String?, @DrawableRes iconId: Int) {
        val item = Item(fragmentClass, title!!, iconId)
        adapter.set(item)
        adapter.notifyDataSetChanged()

        refreshIcons()

    }

    fun add(fragmentClass: Class<out Fragment>, title: String) {
        add(fragmentClass, title, 0)
    }

    fun add(fragmentClass: Class<out Fragment>, iconId: Int) {
        add(fragmentClass, "", iconId)
    }

    private fun refreshIcons() {
        for (i in 0 until adapter.count) {
            val itemIcon = adapter.getRawItem(i).icon
            if (itemIcon != 0) {
                tabLayout.getTabAt(i)?.setIcon(adapter.getRawItem(i).icon)
            }
        }
    }


    class Adapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val items = ArrayList<Item>()

        fun set(item: Item) {
            items.add(item)
        }

        fun getRawItem(position: Int): Item {
            return items[position]
        }

        override fun getItem(position: Int): Fragment {
            return items[position].fragment
        }

        override fun getCount(): Int {
            return items.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return items[position].title
        }


    }

    class Item(fragmentClass: Class<out Fragment>, var title: String, iconId: Int) {
        var fragment: Fragment = fragmentClass.newInstance()
        var icon: Int = iconId

    }


}