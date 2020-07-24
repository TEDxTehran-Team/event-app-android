package co.eventbox.tedxtehran.utilities

import android.widget.ImageView
import co.eventbox.tedxtehran.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */


fun ImageView.load(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun ImageView.loadRadius(url: String?,radius:Int = R.dimen.image_gallery_radius) {

    Glide.with(this)
        .load(url)
        .transform(CenterCrop(), RoundedCorners(this.context.resources.getDimensionPixelOffset(radius)))
        .into(this)
}