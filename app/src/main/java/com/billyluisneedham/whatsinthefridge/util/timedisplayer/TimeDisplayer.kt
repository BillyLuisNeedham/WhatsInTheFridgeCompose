package com.billyluisneedham.whatsinthefridge.util.timedisplayer

interface TimeDisplayer {

    fun getTimeDifferenceMessage(firstTime: Long, secondTime: Long): String
}