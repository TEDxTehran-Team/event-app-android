package co.eventbox.tedxtehran.view.home.speakers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.gone
import co.eventbox.tedxtehran.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main_speakers.*


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class MainEventSpeakersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MainSpeakerAdapter()
        this.recyclerViewSpeakers.adapter = adapter

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.mainEvent().observe(viewLifecycleOwner, {
            this.progressBar.gone()
            adapter.loadedState(it.speakers())
        })


    }
}