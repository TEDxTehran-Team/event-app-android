package co.eventbox.event.view.speakers

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.eventbox.event.R
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.utilities.gone
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import co.eventbox.event.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class SpeakersFragment : Fragment(), ListOnClickListener {
    
    private val speakersViewModel: SpeakersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SpeakerParentAdapter(this)

        recyclerViewSpeakers.isNestedScrollingEnabled = false

        recyclerViewSpeakers.adapter = adapter
        this.speakersViewModel.speakers.observe(viewLifecycleOwner, { either ->

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