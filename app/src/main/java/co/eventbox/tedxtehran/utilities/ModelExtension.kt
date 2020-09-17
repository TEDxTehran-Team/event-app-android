package co.eventbox.tedxtehran.utilities

import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/17/20.
 */

fun DashboardCacheQuery.MainEvent.toDate(): String {
    return "${this.startDate()?.toString().toPersianDate()} تا ${
        this.endDate()?.toString().toPersianDate()
    }"
}