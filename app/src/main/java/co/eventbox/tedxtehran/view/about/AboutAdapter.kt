package co.eventbox.tedxtehran.view.about

import android.content.Context
import co.eventbox.tedxtehran.listener.ListOnClickListener
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.GetAboutsQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_about.view.*
import kotlinx.android.synthetic.main.row_gallery.view.*
import kotlinx.android.synthetic.main.row_gallery.view.txtTitle

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class AboutAdapter : AdapterRecyclerView<GetAboutsQuery.About>(
    R.layout.row_about,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: GetAboutsQuery.About?
    ) {
        val itemView = viewHolder.itemView

        itemView.txtTitle.text = element?.title()
        itemView.txtDescription.text = element?.description()
        itemView.imgAbout.loadRadius(element?.image()?.toImageURL())

    }

}