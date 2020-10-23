package co.eventbox.tedxtehran.view.home

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
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.model.LinkType
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

        viewModel.mainEvent().observe(viewLifecycleOwner, { mainEvent ->
            this.imgBanner.loadRadius(mainEvent?.bannerUrl()?.toImageURL())
            this.imgMap.loadRadius(mainEvent?.venue()?.mapImageUrl().toImageURL())
            this.txtAddressEvent.text = mainEvent?.venue()?.address()
            this.txtLocationEvent.text = mainEvent?.venue()?.title()
            this.txtDateEvent.text = mainEvent?.toDate()


            this.imgMap.setOnClickListener {
                context?.openBrowser(mainEvent?.venue()?.mapLink())

            }

            mainEvent?.links()?.toPair(LinkType.LIVE)?.let {
                this.layoutLiveEvent.visible()
                this.txtTitleLive.text = it.first
            }

            mainEvent?.links()?.toPair(LinkType.TICKET)?.let {
                this.layoutTicket.visible()
                this.txtTitleTicket.text = it.first
            }

            mainEvent?.links()?.toPair(LinkType.REGISTRATION)?.let {
                this.layoutRegister.visible()
                this.txtTitleRegister.text = it.first
            }

            this.layoutLiveEvent.setOnClickListener {
                context?.openBrowser(mainEvent?.links()?.toPair(LinkType.LIVE)?.second)
            }

            this.layoutTicket.setOnClickListener {
                context?.openBrowser(mainEvent?.links()?.toPair(LinkType.TICKET)?.second)
            }

            this.layoutRegister.setOnClickListener {
                context?.openBrowser(mainEvent?.links()?.toPair(LinkType.REGISTRATION)?.second)
            }

            this.layoutSponsor.setOnClickListener {

                findNavController().navigate(R.id.action_ContainerHomeFragment_to_sponsorsFragment,
                    bundleOf
                        ("event_id" to mainEvent.id().toInt()))
            }
        })



    }
}