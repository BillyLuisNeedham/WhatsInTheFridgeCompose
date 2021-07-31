package com.billyluisneedham.whatsinthefridge.util

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TimeConverterKtTest {

    @Test
    fun millisecondsToSeconds_convertedCorrectly_correctValueReturned() {
        val oneSecondInMilliseconds = 1000L

        val result = oneSecondInMilliseconds.millisecondsToSeconds()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToMinutes_convertedCorrectly_correctValueReturned() {
        val oneMinuteInMilliSeconds = 1000L * 60L

        val result = oneMinuteInMilliSeconds.millisecondsToMinutes()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToHours_convertedCorrectly_correctValueReturned() {
        val oneHourInMilliSeconds = 1000L * 60L * 60

        val result = oneHourInMilliSeconds.millisecondsToHours()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToDays_convertedCorrectly_correctValueReturned() {
        val oneDayInMilliSeconds= 1000L * 60L * 60 * 24L

        val result = oneDayInMilliSeconds.millisecondsToDays()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToWeeks_convertedCorrectly_correctValueReturned() {
        val oneWeekInMilliSeconds = 1000 * 60L * 60 * 24 * 7

        val result = oneWeekInMilliSeconds.millisecondsToWeeks()

        assertThat(result, `is`(1))
    }

}


