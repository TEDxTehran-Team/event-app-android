package co.eventbox.event.utilities

import android.widget.ImageView
import androidx.annotation.DrawableRes
import co.eventbox.event.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */


fun ImageView.load(url: String?, @DrawableRes placeHolder: Int = 0) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(placeHolder)
        .into(this)
}

fun ImageView.loadRadius(url: String?, radius: Int = R.dimen.image_gallery_radius) {

    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.placeholdertransparent)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transform(
            CenterCrop(),
            RoundedCorners(this.context.resources.getDimensionPixelOffset(radius))
        )
        .into(this)
}