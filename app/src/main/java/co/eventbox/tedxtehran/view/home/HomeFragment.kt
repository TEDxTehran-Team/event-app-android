package co.eventbox.tedxtehran.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.*
import co.eventbox.tedxtehran.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.mainEvent().observe(viewLifecycleOwner, Observer { mainEvent ->
            this.imgBanner.loadRadius(mainEvent?.bannerUrl()?.toImageURL())
            this.imgMap.loadRadius(mainEvent?.venue()?.mapImageUrl().toImageURL())
            this.txtAddressEvent.text = mainEvent?.venue()?.adress()
            this.txtLocationEvent.text = mainEvent?.venue()?.title()
            this.txtDateEvent.text = mainEvent?.toDate()

            val liveURL = mainEvent?.links()?.first { link ->
                link?.role() == "live"
            }?.url()

            this.imgMap.setOnClickListener {
                openBrowser(mainEvent?.venue()?.mapLink())

            }

            if (liveURL == null) {
                this.layoutLiveEvent.gone()
            }
            this.layoutLiveEvent.setOnClickListener {

                openBrowser(liveURL)
            }
        })

    }
}