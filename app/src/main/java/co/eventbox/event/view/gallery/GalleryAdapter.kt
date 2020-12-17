package co.eventbox.event.view.gallery

import android.content.Context
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.R
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_gallery.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class GalleryAdapter(var listener: ListOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.Album>(
    R.layout.row_gallery,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Album?
    ) {
        val itemView = viewHolder.itemView

        itemView.imgCover.loadRadius(element?.cover()?.toImageURL())
        itemView.txtTitle.text = element?.title()

        itemView.layoutRoot.setOnClickListener {
            this.listener.onSelected(position,element?.id()!!.toInt())
        }

    }

}