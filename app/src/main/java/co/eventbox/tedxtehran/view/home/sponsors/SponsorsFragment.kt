package co.eventbox.tedxtehran.view.home.sponsors

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
import co.eventbox.tedxtehran.viewModel.NewsViewModel
import co.eventbox.tedxtehran.viewModel.SponsorsViewModel
import kotlinx.android.synthetic.main.fragment_sponsors.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class SponsorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sponsors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SponsorParentAdapter()
        this.recyclerViewSponsors.adapter = adapter

        val viewModel = ViewModelProvider(this).get(SponsorsViewModel::class.java)

        viewModel.sponsors().observe(viewLifecycleOwner, {
            this.progressBar.gone()
            adapter.loadedState(it)
        })

    }
}