package co.eventbox.tedxtehran.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import co.eventbox.tedxtehran.listener.ListOnClickListener
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import co.eventbox.tedxtehran.view.adapter.SpeakerParentAdapter
import co.eventbox.tedxtehran.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class SpeakersFragment : BaseFragment(), ListOnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    lateinit var viewModel:SpeakersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.viewModel = ViewModelProvider(this).get(SpeakersViewModel::class.java)
        val adapter = SpeakerParentAdapter(this)

        recyclerViewSpeakers.adapter = adapter

        viewModel.speackers().observe(viewLifecycleOwner, Observer { either ->

            progressBar.gone()
            either.fold({
                Log.d("TAG", "Exception : ${it?.errorMessage}")
            }, { data ->
                if (data?.talksWithEvent() != null) {
                    adapter.items = data.talksWithEvent()!!
                    adapter.notifyDataSetChanged()
                }

                this.imgFeatureTalk.loadRadius(data?.featuredTalk()?.section()?.image()?.toImageURL())
                this.imgFeatureTalk.setOnClickListener {
                    onSelected(0,data?.featuredTalk()?.id()!!.toInt())
                }

            })
        })


    }

    override fun onSelected(position: Int,id:Int) {
        findNavController().navigate(R.id.action_speakersFragment_to_speakersDetailsFragment,
            bundleOf("speaker_id" to id))
    }
}