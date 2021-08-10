package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.util.*

object TimeDisplayerImpl : TimeDisplayer {
    override fun getCurrentTimeInMilliSeconds(): Long {
        return System.currentTimeMillis()
    }

    override fun getTimeDifferenceMessage(
        context: Context,
        firstTimeInMilliSeconds: Long,
        secondTimeInMilliSeconds: Long
    ): String {
        val timeDifferenceList = listOf(firstTimeInMilliSeconds, secondTimeInMilliSeconds).sorted()
        val timeDifferenceInMilliSeconds = timeDifferenceList[1] - timeDifferenceList[0]

        val string = "$timeDifferenceList\n" +
                "timeDiff: $timeDifferenceInMilliSeconds\n" +
                "seconds: ${timeDifferenceInMilliSeconds.millisecondsToSeconds()}\n" +
                "minutes: ${timeDifferenceInMilliSeconds.millisecondsToDays()}\n" +
                "hours: ${timeDifferenceInMilliSeconds.millisecondsToHours()}\n" +
                "days: ${timeDifferenceInMilliSeconds.millisecondsToDays()}\n" +
                "weeks: ${timeDifferenceInMilliSeconds.millisecondsToWeeks()}"

        return when {
            timeDifferenceInMilliSeconds < 10L.secondsToMilliseconds() -> context.getString(R.string.now)

            timeDifferenceInMilliSeconds < 60L.secondsToMilliseconds() -> {
                "${timeDifferenceInMilliSeconds.millisecondsToSeconds()} ${context.getString(R.string.seconds_ago)}"

            }
            timeDifferenceInMilliSeconds < 120L.secondsToMilliseconds() -> context.getString(R.string.minute_ago)

            timeDifferenceInMilliSeconds < 60L.minutesToMilliseconds() -> {
                "${timeDifferenceInMilliSeconds.millisecondsToMinutes()} ${context.getString(R.string.minutes_ago)}"
            }

            timeDifferenceInMilliSeconds < 120L.minutesToMilliseconds() -> context.getString(R.string.one_hour_ago)

            timeDifferenceInMilliSeconds < 24L.hoursToMilliseconds() -> {
                "${timeDifferenceInMilliSeconds.millisecondsToHours()} ${context.getString(R.string.hours_ago)}"
            }

            timeDifferenceInMilliSeconds < 48L.hoursToMilliseconds() -> {
                context.getString(R.string.one_day)
            }

            timeDifferenceInMilliSeconds < 7L.daysToMilliseconds() -> {
                "${timeDifferenceInMilliSeconds.millisecondsToDays()} ${context.getString(R.string.days)}"
            }

            else -> string
        }
    }
}