package co.eventbox.tedxtehran.utilities

import android.content.Context
import android.util.DisplayMetrics
import android.view.View

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