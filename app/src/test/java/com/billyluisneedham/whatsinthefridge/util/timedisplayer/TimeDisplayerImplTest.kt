package com.billyluisneedham.whatsinthefridge.util.timedisplayer

import android.content.Context
import com.billyluisneedham.whatsinthefridge.R
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TimeDisplayerImplTest {

    val mockContext = mockk<Context>()

    @Test
    fun ifTimeIsLessThanTenSecondsReturnsNowString() {
        val nowString = "Now"
        val now = System.currentTimeMillis()
        val fiveSecondsFromNow = now * 5000

        every {
            mockContext.getString(R.string.now)
        } returns nowString


        val result1 = TimeDisplayerImpl.getTimeDifferenceMessage(
            context = mockContext,
            firstTime = now,
            secondTime = fiveSecondsFromNow
        )
        val result2 = TimeDisplayerImpl.getTimeDifferenceMessage(
            context = mockContext,
            firstTime = fiveSecondsFromNow,
            secondTime = now
        )


        assertThat(result1, `is`(nowString))
        assertThat(result2, `is`(nowString))

    }
}