import static java.util.Calendar.*

def date = new Date()
date[YEAR] = 2010
date[MONTH] = JUNE
date[DATE] = 14

assert 110 == date.year
assert 5 == date.month
assert 14 == date.date

assert 2010 == date[YEAR]
assert JUNE == date[MONTH]
assert 14 == date[DATE]

def cal = Calendar.instance
cal[YEAR] = 2000
cal[MONTH] = DECEMBER
cal[DATE] = 25

assert '2000-12-25' == cal.format('yyyy-MM-dd')
assert 2000 == cal[YEAR]


