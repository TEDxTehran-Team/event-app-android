package co.eventbox.event.view.home.speakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import co.eventbox.event.R
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.utilities.gone
import co.eventbox.event.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main_speakers.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class MainEventSpeakersFragment : Fragment(), ListOnClickListener {

    lateinit var adapter: MainSpeakerAdapter

    private val homeViewModel: HomeViewModel by viewModel()

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

        homeViewModel.mainEventLiveData.observe(viewLifecycleOwner, { mainEvent ->
            this.progressBar.gone()

            if (mainEvent?.speakers()?.isEmpty() == false) {
                adapter.loadedState(mainEvent.speakers())
            } else {
                empty_state.visibility = View.VISIBLE
            }
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