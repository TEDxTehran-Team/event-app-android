package co.eventbox.tedxtehran.utilities

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.Fragment

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

fun Fragment.openBrowser(url:String?){
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    startActivity(intent)
}