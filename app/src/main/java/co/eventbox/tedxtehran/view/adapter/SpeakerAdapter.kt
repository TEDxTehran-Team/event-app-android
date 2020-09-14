package co.eventbox.tedxtehran.view.adapter

import android.content.Context
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import co.eventbox.tedxtehran.ListOnClickListener
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import co.eventbox.tedxtehran.view.fragments.SpeakersDetailsFragment
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 7/10/20.
 */
class SpeakerAdapter(var listener:ListOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.Talk>(
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