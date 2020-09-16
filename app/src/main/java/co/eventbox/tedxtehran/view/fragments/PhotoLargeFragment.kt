package co.eventbox.tedxtehran.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.load
import co.eventbox.tedxtehran.utilities.toImageURL
import kotlinx.android.synthetic.main.fragment_photo_large.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class PhotoLargeFragment : BaseFragment() {

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