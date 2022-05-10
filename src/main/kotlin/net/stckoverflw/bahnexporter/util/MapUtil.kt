package net.stckoverflw.bahnexporter.util

import net.stckoverflw.bahnexporter.model.Departures

fun List<Departures>.mapToDelay() = this.map { it.departure?.delay ?: it.arrival!!.delay }
fun List<Departures>.mapToDepartureOrArrival() = this.map { it.departure ?: it.arrival!! }