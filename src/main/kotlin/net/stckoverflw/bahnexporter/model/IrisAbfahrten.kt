package net.stckoverflw.bahnexporter.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IrisAbfahrten(
    val departures: List<Departures>,
)

@Serializable
data class Departures(
    val departure: DepartureArrival? = null,
    val arrival: DepartureArrival? = null,
    val cancelled: Boolean = false,
    @SerialName("reihung") val sameSequence: Boolean = true,
    val train: Train
) {
    @Serializable
    data class DepartureArrival (
        val scheduledTime: Instant,
        val time: Instant,
        val delay: Int = 0,
        val scheduledPlatform: String = "1",
        val platform: String = "1"
    )

    @Serializable
    data class Train(
        val type: String
    )
}
