package co.eventbox.tedxtehran.view.home.speakers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.load
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import kotlinx.android.synthetic.main.fragment_main_speaker_details.*
import kotlinx.android.synthetic.main.row_main_speaker.view.*

/**
 * Created by Mahdi Darvishi.
 * TEDxTehran | Copyrights 11/13/20.
 */
class MainSpeakersDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_speaker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        txtSpeakerName.text = getFromBundle("title")
        txtSpeakerDesc.text = getFromBundle("description")
        imgSpeakerAvatar.load(getFromBundle("imageUrl").toImageURL(), R.drawable.placeholdertransparent)


    }

    // simple method to get string from bunlde
    fun  getFromBundle(key: String): String?{
        return arguments?.getString(key)
    }

}