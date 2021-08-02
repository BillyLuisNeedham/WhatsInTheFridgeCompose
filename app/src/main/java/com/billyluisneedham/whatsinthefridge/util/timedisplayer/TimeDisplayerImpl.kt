package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.util.*

object TimeDisplayerImpl : TimeDisplayer {
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
            timeDifferenceInMilliSeconds.millisecondsToSeconds() < 10 -> context.getString(R.string.now)
            timeDifferenceInMilliSeconds.millisecondsToSeconds() < 60 -> {
                "${timeDifferenceInMilliSeconds.millisecondsToSeconds()} ${context.getString(R.string.seconds_ago)}"

            }
            timeDifferenceInMilliSeconds.millisecondsToSeconds() < 120 -> context.getString(R.string.minute_ago)

            timeDifferenceInMilliSeconds.millisecondsToMinutes() < 120 -> {
                "${timeDifferenceInMilliSeconds.millisecondsToMinutes()} ${context.getString(R.string.minutes_ago)}"
            }
            else -> string
        }
    }
}