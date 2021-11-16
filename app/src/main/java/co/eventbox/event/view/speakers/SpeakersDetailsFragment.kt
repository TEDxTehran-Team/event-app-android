package co.eventbox.event.view.speakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.eventbox.event.R
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.utilities.*
import co.eventbox.event.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speaker_details.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */
class SpeakersDetailsFragment : Fragment(), ListOnClickListener {


    private val speakersViewModel: SpeakersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speaker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.get("speaker_id") as Int

        this.recyclerViewRelated.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, true)
        val adapter = SpeakerRelatedAdapter(this)
        this.recyclerViewRelated.adapter = adapter
        this.speakersViewModel.talkDetails(id).observe(viewLifecycleOwner, { either ->

            this.progressBar.gone()
            this.layoutRoot.visible()
            this.imgPlay.visible()


            either.fold({
                val talk = it?.talk()
                val speakers = arrayListOf<String>()
                talk?.speakers()?.forEach { name ->
                    speakers.add(name.title())
                }

                this.txtTitle.text = talk?.title()
                this.txtSpeakersName.text = speakers.joinToString(", ")
                this.imgBanner.load(talk?.section()?.image()?.toImageURL())
                this.txtDescription.text = talk?.description()

                adapter.loadedState(it?.suggestedTalks()!!)

                this.layoutPlay.setOnClickListener {
                    if (!talk?.videoLink().isNullOrEmpty()) {
                        context?.openBrowser(talk?.videoLink())
                    }
                }
            }, {

            })
        })

    }

    override fun onSelected(position: Int, id: Int) {
        findNavController().navigate(
            R.id.action_speakersDetailsFragment_self,
            bundleOf("speaker_id" to id)
        )
    }
}