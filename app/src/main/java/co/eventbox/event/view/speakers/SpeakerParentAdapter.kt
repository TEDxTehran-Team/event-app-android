package co.eventbox.event.view.speakers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.eventbox.event.Config
import co.eventbox.event.listener.ListOnClickListener
import co.eventbox.event.R
import co.eventbox.event.utilities.toBool
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.android.synthetic.main.row_speaker_parent.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */

class SpeakerParentAdapter(var listener: ListOnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ROW = 1

    var items: List<DashboardCacheQuery.TalksWithEvent> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            val view = inflater.inflate(R.layout.header_row_speakers_list, parent, false)
            return HeaderViewHolder(view)
        }

        val view = inflater.inflate(R.layout.row_speaker_parent, parent, false)
        return RowViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemView = holder.itemView

        when (holder) {
            is RowViewHolder -> {
                val item = items[position]
                itemView.txtTitle.text = item.event()?.title()
                val adapterSpeakers = SpeakerAdapter(this.listener)
                itemView.recyclerViewChild.adapter = adapterSpeakers
                itemView.recyclerViewChild.layoutManager = LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapterSpeakers.loadedState(item.talks())

            }
            is HeaderViewHolder -> {
                val item = items[position]

//                itemView.imgBanner.loadRadius(item.event()?.bannerUrl()?.toImageURL())
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
//        if (position == 0) {
//            return ITEM_VIEW_TYPE_HEADER
//        }
        return ITEM_VIEW_TYPE_ROW
    }


    class RowViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)
}