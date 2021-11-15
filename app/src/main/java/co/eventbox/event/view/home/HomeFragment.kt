package co.eventbox.event.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import co.eventbox.event.Config
import co.eventbox.event.R
import co.eventbox.event.model.LinkType
import co.eventbox.event.utilities.*
import co.eventbox.event.viewModel.HomeViewModel
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 2019-09-26.
 */
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.mainEventLiveData.observe(viewLifecycleOwner, { mainEvent ->
            populateView(mainEvent)
        })


    }

    private fun populateView(mainEvent: DashboardCacheQuery.MainEvent?) {
        this.imgBanner.loadRadius(mainEvent?.bannerUrl()?.toImageURL())

        // when map photo link is empty, set ImageView Visibility gone
        if (!mainEvent?.venue()?.mapImageUrl().isNullOrEmpty()) {
            this.imgMap.loadRadius(mainEvent?.venue()?.mapImageUrl().toImageURL())
        } else {
            this.imgMap.visibility = View.GONE
            this.cardView.visibility = View.GONE
        }

        this.txtAddressEvent.text = mainEvent?.venue()?.address()
        this.txtLocationEvent.text = mainEvent?.venue()?.title()

        if (Config.language == Constants.ENGLISH) {
            this.txtDateEvent.text = mainEvent?.toEnglishDate()
        }

        if (Config.language == Constants.PERSIAN) {
            this.txtDateEvent.text = mainEvent?.toPersianDate()
        }


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

            findNavController().navigate(
                R.id.action_ContainerHomeFragment_to_sponsorsFragment,
                bundleOf
                    ("event_id" to mainEvent?.id()?.toInt())
            )
        }
    }
}