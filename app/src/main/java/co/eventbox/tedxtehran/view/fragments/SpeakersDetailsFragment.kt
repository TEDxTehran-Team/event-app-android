package co.eventbox.tedxtehran.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.eventbox.tedxtehran.R

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */
class SpeakersDetailsFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speaker_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id =  arguments?.get("speaker_id") as String
    }
}