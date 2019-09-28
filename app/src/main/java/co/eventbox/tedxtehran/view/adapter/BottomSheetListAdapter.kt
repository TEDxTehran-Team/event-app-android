package co.eventbox.tedxtehran.view.adapter

import android.annotation.SuppressLint
import android.content.Context

import androidx.annotation.MenuRes

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.google.android.material.bottomnavigation.BottomNavigationMenu

import androidx.databinding.DataBindingUtil
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.databinding.BottomsheetItemListBinding

@SuppressLint("RestrictedApi")
class BottomSheetListAdapter(context: Context, @MenuRes menu: Int) : ArrayAdapter<MenuItem>(context, R.layout.bottomsheet_item_list) {


    private val menu = BottomNavigationMenu(getContext())
    private var menuClickListener: MenuItem.OnMenuItemClickListener? = null

    init {
        MenuInflater(getContext()).inflate(menu, this.menu)
    }

    fun setOnMenuClickListener(menuClickListener: MenuItem.OnMenuItemClickListener) {
        this.menuClickListener = menuClickListener
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (convertView !=
                null) {
            return convertView
        }

        @SuppressLint("ViewHolder")
        val binding = DataBindingUtil.inflate<BottomsheetItemListBinding>(
                LayoutInflater.from(context),
                R.layout.bottomsheet_item_list, null,
                false)

        val menuItem = menu.getItem(position)
        binding.imgIcon.setImageDrawable(menuItem.icon)
        binding.txtTitle.text = menuItem.title
        binding.root.setOnClickListener { if (menuClickListener != null) menuClickListener!!.onMenuItemClick(menuItem) }
        return binding.root
    }


    override fun getCount(): Int {
        return menu.size()
    }
}
