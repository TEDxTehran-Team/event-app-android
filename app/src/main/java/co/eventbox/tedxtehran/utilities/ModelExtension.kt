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

fun DashboardCacheQuery.Section2.toTime(): String {

    val start = this.startTime().toString().split(":")
    val end = this.endTime().toString().split(":")

    return "${start[0]}:${start[1]} الی ${end[0]}:${end[1]}"
}
fun DashboardCacheQuery.Session.toTime(): String {

    val start = this.startTime().toString().split(":")
    return "${start[0]}:${start[1]}"
}