package co.eventbox.event.view.speakers

import android.content.Context
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.R
import co.eventbox.event.utilities.loadRadius
import co.eventbox.event.utilities.toImageURL
import co.eventbox.event.view.AdapterRecyclerView
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class SpeakerAdapter(var listener: ListOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.Talk>(
    R.layout.row_speaker,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Talk?
    ) {
        val itemView = viewHolder.itemView

        itemView.img_speaker.loadRadius(element?.section()?.image()?.toImageURL())
        itemView.txtTitle.text = element?.title()

        val speakers = arrayListOf<String>()
        element?.speakers()?.forEach {
            speakers.add(it.title())
        }
        itemView.txtSpeakersName.text = speakers.joinToString(", ")

        itemView.layoutRoot.setOnClickListener {
            this.listener.onSelected(position,element!!.id().toInt())
        }
    }

}