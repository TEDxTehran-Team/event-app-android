package co.eventbox.tedxtehran.view.home.speakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.listener.ListOnClickListener
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main_speakers.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class MainEventSpeakersFragment() : Fragment(), ListOnClickListener {

    lateinit var adapter: MainSpeakerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MainSpeakerAdapter(this)
            this.recyclerViewSpeakers.adapter = adapter
            val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

            viewModel.mainEvent().observe(viewLifecycleOwner, {
                this.progressBar.gone()
                adapter.loadedState(it.speakers())
            })



    }


    override fun onSelected(position: Int, id: Int) {

        val bundle = Bundle()
        val item = adapter.getItem(position)
        bundle.putString("title", item?.title())
        bundle.putString("description", item?.description())
        bundle.putString("imageUrl", item?.imageUrl())

        findNavController().navigate(
            R.id.action_ContainerHomeFragment_to_mainSpeakersDetailsFragment,
            bundle

        )
    }
}