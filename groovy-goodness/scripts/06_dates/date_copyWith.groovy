// Date.copyWith 를 통해 기존 객체를 복제하면서 특정 값만 바꾼 새로운 객체 생성가능. updated랑 뭔차이지?
// updated -> copyWith 로 이름이 바뀌었음.

import static java.util.Calendar.NOVEMBER

def date = new Date().clearTime()
date.set(year: 2013, month: NOVEMBER, date: 18)

def yearLater = date.copyWith(year: 2014)

assert yearLater.format('dd-MM-yyyy') == '18-11-2014'
assert !date.is(yearLater)

def cal = Calendar.instance
cal.set(year: 2013, month: NOVEMBER, date: 10)
def newCalendar = cal.copyWith(date: 18)

assert newCalendar.format('dd-MM-yyyy') == '18-11-2013'