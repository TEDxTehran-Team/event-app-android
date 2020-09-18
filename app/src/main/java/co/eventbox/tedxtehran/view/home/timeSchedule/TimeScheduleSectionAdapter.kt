package co.eventbox.tedxtehran.view.home.timeSchedule

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.Switch
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.utilities.toTime
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import com.apollographql.apollo.co.eventbox.tedxtehran.type.SectionType
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_time_schedule_section.view.*

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

    when (this) {
        SectionType.ACTIVITY -> {
            return R.drawable.circle_activity
        }
        SectionType.ENTERTAINMENT -> {
            return R.drawable.circle_intertaiment
        }
        SectionType.GENERIC -> {
            return R.drawable.circle_generic
        }
        SectionType.PERFORMANCE -> {
            return R.drawable.circle_performance
        }
        else -> return R.drawable.circle_intertaiment
    }


}