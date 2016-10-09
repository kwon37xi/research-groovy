import groovy.time.DatumDependentDuration
import groovy.time.TimeCategory
import groovy.time.TimeDuration

def period = new DatumDependentDuration(2, 3, 15, 0, 23, 2, 0) // 2년 3개월 15일 0시간 23분 2초 0ms
assert '2 years, 3 months, 15 days, 23 minutes, 2.000 seconds' == period.toString()

def year2000 = new Date(100, 0, 0) // Jan 1, 2000
assert '14 Apr 2002 15:23:02 GMT' == (period + year2000).toGMTString() // Date 객체 TimeZone에 따라 달라짐.

def time = new TimeDuration(5, 54, 0, 30) // 5시간 54분 0초 30ms
assert '5 hours, 54 minutes, 0.030 seconds' == time.toString()

use (TimeCategory) {
    assert period.toString() == (2.years + 3.months + 15.days + 0.hour + 23.minutes + 2.seconds).toString()
    assert time.toString() == (5.hours + 54.minutes + 0.second + 30.milliseconds).toString()

    def d1 = 1.week - 1.day
    def d2 = new Date() + 6.days
    assert d2.format('yyyy-MM-dd') == d1.from.now.format('yyyy-MM-dd')

    def d3 = 3.days.ago
    def d4 = new Date() - 3
    assert d4.format('yyyy-MM-dd') == d3.format('yyyy-MM-dd')
}


