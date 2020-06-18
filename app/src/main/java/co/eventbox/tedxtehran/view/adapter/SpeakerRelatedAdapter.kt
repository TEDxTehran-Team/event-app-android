package co.eventbox.tedxtehran.view.adapter

import android.content.Context
import co.eventbox.tedxtehran.R
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 6/18/20.
 */
class SpeakerRelatedAdapter : AdapterRecyclerView<String>(
    R.layout.row_speaker_related,
    R.layout.row_progress_view,
    R.layout.row_error,
    R.id.btn_error_list) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: String?
    ) {
    }
}