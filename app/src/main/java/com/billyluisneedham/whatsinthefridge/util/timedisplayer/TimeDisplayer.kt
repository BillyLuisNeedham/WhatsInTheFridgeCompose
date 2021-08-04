package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context

interface TimeDisplayer {

    fun getTimeDifferenceMessage(context: Context, firstTimeInMilliSeconds: Long, secondTimeInMilliSeconds: Long): String
}