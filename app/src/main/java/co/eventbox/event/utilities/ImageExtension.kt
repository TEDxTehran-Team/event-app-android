package co.eventbox.event.utilities

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import coil.request.CachePolicy
import coil.transform.RoundedCornersTransformation

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */


fun ImageView.load(url: String?, @DrawableRes placeHolder: Int = 0) {
    this.load(url) {
        placeholder(placeHolder)
        error(placeHolder)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}

fun ImageView.loadRadius(url: String?) {

    this.load(url) {
        diskCachePolicy(CachePolicy.ENABLED)
        transformations(RoundedCornersTransformation(10f))
    }
}