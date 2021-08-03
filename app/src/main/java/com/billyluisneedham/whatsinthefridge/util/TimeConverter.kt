package com.billyluisneedham.whatsinthefridge.util

fun Long.millisecondsToSeconds(): Long {
    return this / 1000
}

fun Long.millisecondsToMinutes(): Long {
    return this / 1000 / 60
}

fun Long.millisecondsToHours(): Long {
    return this / 1000 / 60 / 60
}

fun Long.millisecondsToDays(): Long {
    return this / 1000 / 60 / 60 / 24
}

fun Long.millisecondsToWeeks(): Long {
    return this / 1000 / 60 / 60/ 24 / 7
}

fun Long.secondsToMilliseconds(): Long {
    return this * 1000
}

fun Long.minutesToMilliseconds(): Long {
    return this * 1000 * 60
}

fun Long.hoursToMilliseconds(): Long {
    return this * 1000 * 60 * 60
}

fun Long.daysToMilliseconds(): Long {
    return this * 1000 * 60 * 60 * 24
}

fun Long.weeksToMilliseconds(): Long {
    return this * 1000 * 60 * 60 * 24 * 7
}