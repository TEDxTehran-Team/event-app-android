package co.eventbox.event.view.speakers

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.R
import co.eventbox.event.utilities.gone
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import co.eventbox.event.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_main_speakers.*
import kotlinx.android.synthetic.main.fragment_speakers.*
import kotlinx.android.synthetic.main.fragment_speakers.progressBar
import kotlinx.android.synthetic.main.fragment_speakers.recyclerViewSpeakers

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class SpeakersFragment : Fragment(), ListOnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    lateinit var viewModel: SpeakersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel = ViewModelProvider(this).get(SpeakersViewModel::class.java)
        val adapter = SpeakerParentAdapter(this)

        recyclerViewSpeakers.adapter = adapter
        viewModel.speackers().observe(viewLifecycleOwner, Observer { either ->

            progressBar.gone()
            either.fold({ data ->

                if (data?.talksWithEvent() != null) {
                    adapter.items = data.talksWithEvent()!!
                    adapter.notifyDataSetChanged()
                }

                this.imgFeatureTalk.loadRadius(
                    data?.featuredTalk()?.section()?.image()?.toImageURL()
                )
                this.imgFeatureTalk.setOnClickListener {
                    onSelected(0, data?.featuredTalk()?.id()!!.toInt())
                }


            }, {
                Log.d("TAG", "Exception : ${it.message}")
            })
        })


    }

    override fun onSelected(position: Int, id: Int) {
        findNavController().navigate(
            R.id.action_speakersFragment_to_speakersDetailsFragment,
            bundleOf("speaker_id" to id)
        )
    }
}