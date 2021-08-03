package com.billyluisneedham.whatsinthefridge.util

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TimeConverterKtTest {

    private val oneSecondInMilliseconds = 1000L
    private val oneMinuteInMilliSeconds = 1000L * 60L
    private val oneHourInMilliSeconds = 1000L * 60L * 60
    private val oneDayInMilliSeconds= 1000L * 60L * 60 * 24L
    private val oneWeekInMilliSeconds = 1000 * 60L * 60 * 24 * 7

    @Test
    fun millisecondsToSeconds_convertedCorrectly_correctValueReturned() {
        val result = oneSecondInMilliseconds.millisecondsToSeconds()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToMinutes_convertedCorrectly_correctValueReturned() {
        val result = oneMinuteInMilliSeconds.millisecondsToMinutes()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToHours_convertedCorrectly_correctValueReturned() {
        val result = oneHourInMilliSeconds.millisecondsToHours()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToDays_convertedCorrectly_correctValueReturned() {
        val result = oneDayInMilliSeconds.millisecondsToDays()

        assertThat(result, `is`(1))
    }

    @Test
    fun millisecondsToWeeks_convertedCorrectly_correctValueReturned() {
        val result = oneWeekInMilliSeconds.millisecondsToWeeks()

        assertThat(result, `is`(1))
    }

    @Test
    fun secondsToMilliseconds_convertedCorrectly_correctValueReturned() {
        val result = 1L.secondsToMilliseconds()

        assertThat(result, `is`(oneSecondInMilliseconds))
    }

    @Test
    fun minutesToMilliseconds_convertedCorrectly_correctValueReturned() {
        val result = 1L.minutesToMilliseconds()

        assertThat(result, `is`(oneMinuteInMilliSeconds))
    }

    @Test
    fun hoursToMilliseconds_convertedCorrectly_correctValueReturned() {
        val result = 1L.hoursToMilliseconds()

        assertThat(result, `is`(oneHourInMilliSeconds))
    }

    @Test
    fun daysToMilliseconds_convertedCorrectly_correctValueReturned() {
        val result = 1L.daysToMilliseconds()

        assertThat(result, `is`(oneDayInMilliSeconds))
    }

    @Test
    fun weeksToMilliseconds_convertedCorrectly_correctValueReturned() {
        val result = 1L.weeksToMilliseconds()

        assertThat(result, `is`(oneWeekInMilliSeconds))
    }

}


