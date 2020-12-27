package co.eventbox.event.utilities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.Fragment
import co.eventbox.event.view.activities.MainActivity

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun Fragment.showBottomNav() {
    (activity as MainActivity).showBottomNav()
}

fun Fragment.hideBottomNav() {
    (activity as MainActivity).hideBottomNav()
}

fun Fragment.hideAppbar() {
    (activity as MainActivity).hideAppBar()
}

fun Fragment.showAppbar() {
    (activity as MainActivity).showAppBar()
}




fun Context.openBrowser(url: String?) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    startActivity(intent)
}