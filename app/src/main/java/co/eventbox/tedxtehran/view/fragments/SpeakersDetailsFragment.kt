package co.eventbox.tedxtehran.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.eventbox.tedxtehran.ListOnClickListener
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.utilities.load
import co.eventbox.tedxtehran.utilities.toImageURL
import co.eventbox.tedxtehran.utilities.visible
import co.eventbox.tedxtehran.view.adapter.SpeakerAdapter
import co.eventbox.tedxtehran.view.adapter.SpeakerRelatedAdapter
import co.eventbox.tedxtehran.viewModel.SpeakersViewModel
import com.apollographql.apollo.co.eventbox.tedxtehran.GetTalkDetailQuery
import kotlinx.android.synthetic.main.fragment_speaker_details.*
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */
class SpeakersDetailsFragment : BaseFragment() ,ListOnClickListener{


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speaker_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id =  arguments?.get("speaker_id") as Int

        val viewModel = ViewModelProvider(this).get(SpeakersViewModel::class.java)

        this.recyclerViewRelated.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,true)
        val adapter = SpeakerRelatedAdapter(this)
        this.recyclerViewRelated.adapter = adapter
        viewModel.talkDetails(id).observe(viewLifecycleOwner, Observer {either ->

            this.progressBar.gone()
            this.layoutRoot.visible()


            either.fold({

            },{
                val talk = it?.talk()
                val speakers = arrayListOf<String>()
                talk?.speakers()?.forEach {name ->
                    speakers.add(name.title())
                }

                this.txtTitle.text = talk?.title()
                this.txtSpeakersName.text = speakers.joinToString(", ")
                this.imgBanner.load(talk?.section()?.image()?.toImageURL())
                this.txtDescription.text = talk?.description()

                adapter.loadedState(it?.suggestedTalk()!!)
            })
        })

    }

    override fun onSelected(position: Int, id: Int) {
        findNavController().navigate(R.id.action_speakersDetailsFragment_self,
            bundleOf("speaker_id" to id)
        )
    }
}