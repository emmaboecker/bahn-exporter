package net.stckoverflw.bahnexporter.util

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.write.Point
import kotlinx.datetime.Clock

const val tagName = "station"

fun delayPoint(station: String, minDelay: Int, maxDelay: Int, delaySum: Int, averageDelay: Double) =
    Point.measurement("delay")
        .addTag(tagName, station)
        .addField("min", minDelay)
        .addField("max", maxDelay)
        .addField("sum", delaySum)
        .addField("average", averageDelay)
        .time(Clock.System.now().toEpochMilliseconds(), WritePrecision.MS)


fun planPoint(station: String, cancellations: Int, notPlannedSequences: Int, differentPlatform: Int) =
    Point.measurement("plan")
        .addTag(tagName, station)
        .addField("cancellations", cancellations)
        .addField("not_planned_sequences", notPlannedSequences)
        .addField("different_platforms", differentPlatform)
        .time(Clock.System.now().toEpochMilliseconds(), WritePrecision.MS)

fun trainCountPoint(station: String, count: Int) =
    Point.measurement("train_count")
        .addTag(tagName, station)
        .addField("count", count)
        .time(Clock.System.now().toEpochMilliseconds(), WritePrecision.MS)