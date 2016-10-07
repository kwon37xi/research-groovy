import static java.util.Calendar.*

def date = new Date()
date.clearTime() // time to 00:00:00
date.set year: 2010, month: AUGUST, date: 10


def sqlTimestamp = date.toTimestamp()
assert 'java.sql.Timestamp' == sqlTimestamp.class.name
assert '2010-08-10 00:00:00.0' == sqlTimestamp.toString()

def cDate = new Date()
cDate.set year: 2010, month: 11, date: 16

def calendar = cDate.toCalendar()

assert calendar[YEAR] == 2010
assert calendar[MONTH] == Calendar.DECEMBER
assert calendar[DATE] == 16
assert calendar.format('dd-MM-yyyy') == '16-12-2010'
assert calendar in Calendar