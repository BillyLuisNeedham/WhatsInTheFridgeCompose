package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context
import android.util.Log

object TimeDisplayerImpl : TimeDisplayer {
    override fun getTimeDifferenceMessage(
        context: Context,
        firstTime: Long,
        secondTime: Long
    ): String {
        //create a list of firstTime secondTime
        val timeDifference = listOf(firstTime, secondTime).also {
            it.sorted()

            //TODO REMOVE WHEN DONE TESTING
            Log.d()
        }
        //sort list into order of smallest to largest
        //get result of list[1] - list[0]
        //if result is < 10 seconds return now string

        return ""
    }
}