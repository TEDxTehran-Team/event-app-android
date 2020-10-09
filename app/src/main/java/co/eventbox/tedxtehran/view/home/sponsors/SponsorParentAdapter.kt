package co.eventbox.tedxtehran.view.home.sponsors

import android.content.Context
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import co.eventbox.tedxtehran.R
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetEventSponsorsQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_sponsor_parent.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class SponsorParentAdapter : AdapterRecyclerView<GetEventSponsorsQuery.SponsorsWithType>(
    R.layout.row_sponsor_parent,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {


    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: GetEventSponsorsQuery.SponsorsWithType?
    ) {
        val itemView = viewHolder.itemView

        itemView.txtTitle.text = element?.type()?.title()

        val adapter = SponsorAdapter()
        adapter.loadedState(element?.sponsors())
        itemView.recyclerSponsors.adapter = adapter
        itemView.recyclerSponsors.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)

    }
}