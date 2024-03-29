package co.eventbox.event.view.about

import android.content.Context
import co.eventbox.event.R
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import co.eventbox.event.view.AdapterRecyclerView
import com.apollographql.apollo.co.eventbox.event.GetAboutsQuery
import kotlinx.android.synthetic.main.row_about.view.*
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