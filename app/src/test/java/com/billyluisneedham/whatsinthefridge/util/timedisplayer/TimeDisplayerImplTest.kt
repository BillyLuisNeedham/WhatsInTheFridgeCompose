package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context
import com.billyluisneedham.whatsinthefridge.R
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class TimeDisplayerImplTest {

    private val mockContext = mockk<Context>()
    private var now: Long? = null

    @Before
    fun setUp() {
        now = System.currentTimeMillis()
    }

    @After
    fun cleanUp() {
        now = null
    }

    @Test
    fun theSameResultIsReturnedRegardlessOfTheOrderTheNumbersAreEntered() {
        val nowString = "Now"
        every {
            mockContext.getString(R.string.now)
        } returns nowString

        val fiveSecondsFromNow = now!! + 5000


        val result1 = TimeDisplayerImpl.getTimeDifferenceMessage(
            context = mockContext,
            firstTimeInMilliSeconds = now!!,
            secondTimeInMilliSeconds = fiveSecondsFromNow
        )
        val result2 = TimeDisplayerImpl.getTimeDifferenceMessage(
            context = mockContext,
            firstTimeInMilliSeconds = fiveSecondsFromNow,
            secondTimeInMilliSeconds = now!!
        )


        assertThat(result1, `is`(nowString))
        assertThat(result2, `is`(nowString))

    }

    @Test
    fun ifTimeIsLessThanTenSecondsReturnsNowString() {
        val nowString = "Now"
        every {
            mockContext.getString(R.string.now)
        } returns nowString
        val zeroToTenSecondsInMilliSeconds = (0..9).map { it * 1000L }


        val results: List<String> = zeroToTenSecondsInMilliSeconds.map {
            TimeDisplayerImpl.getTimeDifferenceMessage(
                context = mockContext,
                firstTimeInMilliSeconds = now!!,
                secondTimeInMilliSeconds = it + now!!
            )
        }


        results.forEach {
            assertThat(it, `is`(nowString))
        }
    }

    @Test
    fun ifTimeIsLessThanOneMinuteButMoreThanTenSecondsReturnsNumberOfSeconds() {
        val secondsString = "seconds ago"
        every {
            mockContext.getString(R.string.seconds_ago)
        } returns secondsString
        val tenToFiftyNine = (10..59).toList()
        val tenToFiftyNineInMilliSeconds = tenToFiftyNine.map { it * 1000L }


        val result = tenToFiftyNineInMilliSeconds.map {
            TimeDisplayerImpl.getTimeDifferenceMessage(
                context = mockContext,
                firstTimeInMilliSeconds = now!!,
                secondTimeInMilliSeconds = it + now!!
            )
        }


        result.forEachIndexed { index, string ->
            assertThat(string, `is`("${tenToFiftyNine[index]} $secondsString"))
        }
    }

    @Test
    fun ifTimeIsLessOneHundredAndTwentySecondsAgoButMoreThanSixtySecondsReturnsOneMinute() {
        val minuteString = "1 minute ago"
        every {
            mockContext.getString(R.string.minute_ago)
        } returns minuteString
        val secondsRange = (61..119).toList()
        val secondsRangeInMilliSeconds = secondsRange.map { it * 1000L }

        //TODO refactor out into own function to make DRY
        val result = secondsRangeInMilliSeconds.map {
            TimeDisplayerImpl.getTimeDifferenceMessage(
                context = mockContext,
                firstTimeInMilliSeconds = now!!,
                secondTimeInMilliSeconds = it + now!!
            )
        }


        result.forEach {
            assertThat(it, `is`(minuteString))
        }

    }

    @Test
    fun ifTimeIsLessThanOneHourButMoreThanOneHundredAndNineteenSecondsReturnsAmountOfMinutesWithMinutesAgoString() {
        val minutesString = "minutes ago"
        every {
            mockContext.getString(R.string.minutes_ago)
        } returns minutesString
        val twoToFiftyNine = (2..59).toList()
        val twoToFiftyNineMinutesInMilliSeconds =
            twoToFiftyNine.map { it * 1000L * 60 }


        val result = twoToFiftyNineMinutesInMilliSeconds.map {
            TimeDisplayerImpl.getTimeDifferenceMessage(
                context = mockContext,
                firstTimeInMilliSeconds = it + now!!,
                secondTimeInMilliSeconds = now!!
            )
        }


        result.forEachIndexed { index, string ->
            assertThat(string, `is`("${twoToFiftyNine[index]} $minutesString"))
        }
    }

    @Test
    fun ifTimeIsMoreThanFiftyNineMinutesButLessThanOneHundredAndTwentyMinutesReturnsOneHourAgoString() {
        //TODO MAKE PASS

        val oneHourAgoString = "1 hour ago"
        every {
            mockContext.getString(R.string.one_hour_ago)
        } returns oneHourAgoString
        val sixtyToOneHundredAndNineteen = (60..119).toList()
        val timeRangeConvertedFromMinutesToMilliSeconds =
            sixtyToOneHundredAndNineteen.map { it * 60 * 1000L }


        val result = timeRangeConvertedFromMinutesToMilliSeconds.map {
            TimeDisplayerImpl.getTimeDifferenceMessage(
                context = mockContext,
                firstTimeInMilliSeconds = it + now!!,
                secondTimeInMilliSeconds = now!!
            )
        }


        result.forEachIndexed { index, string ->
            assertThat(string, `is`(oneHourAgoString))
        }
    }

}