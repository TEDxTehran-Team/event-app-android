package co.eventbox.event.utilities

import co.eventbox.event.model.LinkType
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 9/17/20.
 */

fun DashboardCacheQuery.MainEvent.toPersianDate(): String {
    return "${this.startDate()?.toString().toPersianDate()} تا ${
        this.endDate()?.toString().toPersianDate()
    }"
}

fun DashboardCacheQuery.MainEvent.toEnglishDate(): String {
    return "${this.startDate()?.toString()?.substringBefore("T")} to ${
        this.endDate()?.toString()?.substringBefore("T")
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

fun List<DashboardCacheQuery.Link>?.toPair(type: LinkType): Pair<String?, String?>? {
    val item = this?.firstOrNull { item ->
        item.role() == type.name
    }
        ?: return null
    return Pair(item.title(), item.url())
}
