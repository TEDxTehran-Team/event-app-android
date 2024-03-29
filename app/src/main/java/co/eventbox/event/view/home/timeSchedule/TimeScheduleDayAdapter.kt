package co.eventbox.event.view.home.timeSchedule

import android.content.Context
import co.eventbox.event.R
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import kotlinx.android.synthetic.main.row_time_schedule_day.view.*
import kotlinx.android.synthetic.main.row_time_schedule_section.view.txtTitle
import co.eventbox.event.view.AdapterRecyclerView


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/18/20.
 */
class TimeScheduleDayAdapter : AdapterRecyclerView<DashboardCacheQuery.Day>(
    R.layout.row_time_schedule_day,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Day?
    ) {
        val itemView = viewHolder.itemView

        if (element?.sessions()!!.size > 0)
            itemView.txtTitle.text = element.title()

        val adapter = TimeScheduleSessionAdapter()
        adapter.loadedState(element.sessions())
        itemView.recyclerSessions.adapter = adapter

    }

}