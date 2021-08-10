package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context

interface TimeDisplayer {

    fun getCurrentTimeInMilliSeconds(): Long

    fun getTimeDifferenceMessage(
        context: Context,
        firstTimeInMilliSeconds: Long, secondTimeInMilliSeconds: Long
    ): String

    fun getTimeDifferenceMessageBetweenNowAnd(
        timeInMilliSeconds: Long,
        context: Context
    ) = getTimeDifferenceMessage(
        context = context,
        firstTimeInMilliSeconds = getCurrentTimeInMilliSeconds(),
        secondTimeInMilliSeconds = timeInMilliSeconds
    )

}