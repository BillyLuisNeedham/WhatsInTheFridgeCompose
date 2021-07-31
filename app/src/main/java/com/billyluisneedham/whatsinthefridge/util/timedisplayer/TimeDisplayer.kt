package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context

interface TimeDisplayer {

    fun getTimeDifferenceMessage(context: Context, firstTime: Long, secondTime: Long): String
}