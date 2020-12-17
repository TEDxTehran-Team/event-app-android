package co.eventbox.event.view.home.sponsors

import android.content.Context
import co.eventbox.event.R
import co.eventbox.event.utilities.load
import co.eventbox.event.utilities.openBrowser
import co.eventbox.event.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.event.GetEventSponsorsQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_sponsor.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class SponsorAdapter : AdapterRecyclerView<GetEventSponsorsQuery.Sponsor>(
    R.layout.row_sponsor,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: GetEventSponsorsQuery.Sponsor?
    ) {
        val itemView = viewHolder.itemView
        itemView.imgSponsor.load(element?.logo()?.toImageURL())
        itemView.txtTitle.text = element?.title()
        itemView.layoutRoot.setOnClickListener {
            if (!element?.link().isNullOrEmpty())
                itemView.context.openBrowser(element?.link())
        }
    }

}