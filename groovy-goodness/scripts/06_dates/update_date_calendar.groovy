// Date/Calendar 객체를 Map으로 update해서 새로운 결과 객체를 만들어낼 수 있다.
// Map 에 지정안한 값은 변경없이 유지한다.

import static java.util.Calendar.*

def cal = Calendar.instance
cal[MONTH] = DECEMBER

def calNextMonth = cal.updated(month: cal[MONTH] + 1, year: 2012)

assert JANUARY == calNextMonth[MONTH]
assert 2013 == calNextMonth[YEAR] // 12월에서 1월을 더하면서 1년이 넘어감.

def date = new Date()
date.set(year: 2011, month: MAY, date: 5)
def dateTenYearsAgo = date.updated(year: date[YEAR] - 10)

assert '2011-5-5' == date.format('yyyy-M-d')
assert '2001-5-5' == dateTenYearsAgo.format('yyyy-M-d')