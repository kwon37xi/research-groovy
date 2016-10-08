// Date.parseToStringDate(Date.toString())
// Date.toString()의 format은 "EEE MMM dd HH:mm:ss zzz yyyy" with US Locale

import static java.util.Calendar.*

def cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"))
def date = cal.time

date.clearTime()
date[YEAR] = 2011
date[MONTH] = NOVEMBER
date[DATE] = 10

def dateToString = date.toString()
assert dateToString == 'Thu Nov 10 00:00:00 KST 2011'

dateString = dateToString.replaceFirst('Nov', 'Dec').replace('10', '24')

def newDate = Date.parseToStringDate(dateString)

assert newDate[MONTH] == DECEMBER
assert newDate[DATE] == 24
assert newDate[YEAR] == 2011
