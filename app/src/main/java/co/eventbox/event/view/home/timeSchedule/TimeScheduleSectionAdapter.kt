package co.eventbox.event.view.home.timeSchedule

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import co.eventbox.event.R
import co.eventbox.event.utilities.toTime
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.event.type.SectionType
import kotlinx.android.synthetic.main.row_time_schedule_section.view.*
import co.eventbox.event.view.AdapterRecyclerView

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/18/20.
 */
class TimeScheduleSectionAdapter : AdapterRecyclerView<DashboardCacheQuery.Section2>(
    R.layout.row_time_schedule_section,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Section2?
    ) {
        val itemView = viewHolder.itemView
        itemView.txtTitle.text = element?.title()
        itemView.txtTime.text = element?.toTime()

        itemView.imgColor.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                element?.type()!!.toShape()
            )
        )
    }

}

@DrawableRes
fun SectionType.toShape(): Int {

    return when (this) {
        SectionType.ACTIVITY -> {
            R.drawable.circle_activity
        }
        SectionType.ENTERTAINMENT -> {
            R.drawable.circle_intertaiment
        }
        SectionType.GENERIC -> {
            R.drawable.circle_generic
        }
        SectionType.PERFORMANCE -> {
            R.drawable.circle_performance
        }
        else -> R.drawable.circle_intertaiment
    }


}