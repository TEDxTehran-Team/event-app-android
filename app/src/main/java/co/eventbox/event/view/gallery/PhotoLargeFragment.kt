package co.eventbox.event.view.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.event.R
import co.eventbox.event.utilities.load
import co.eventbox.event.utilities.toImageURL
import kotlinx.android.synthetic.main.fragment_photo_large.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class PhotoLargeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_large, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.get("photo_url") as String
        this.imgPhoto.load(url.toImageURL(),placeHolder = R.drawable.ic_gallery)



    }
}