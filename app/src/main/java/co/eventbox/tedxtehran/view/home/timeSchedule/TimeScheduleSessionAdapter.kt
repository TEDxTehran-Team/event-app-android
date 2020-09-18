package co.eventbox.tedxtehran.view.home.timeSchedule

import android.content.Context
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.toTime
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_time_schedule_session.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/18/20.
 */
class TimeScheduleSessionAdapter : AdapterRecyclerView<DashboardCacheQuery.Session>(
    R.layout.row_time_schedule_session,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Session?
    ) {
        val itemView = viewHolder.itemView

        itemView.txtSessionTitle.text = element?.title()
        itemView.txtSessionTime.text = element?.toTime()

        val adapter = TimeScheduleSectionAdapter()
        adapter.loadedState(element?.sections())
        itemView.recyclerSection.adapter = adapter

    }

}