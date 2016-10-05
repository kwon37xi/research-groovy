date = Date.parse('yyyy/MM/dd', '1973/07/09')

assert 1973 == date[Calendar.YEAR]
assert 6 == date[Calendar.MONTH]
assert 9 == date.getAt(Calendar.DATE)

dateNext = date.clone()
datePrevious = date.clone()

nextDay = date + 1
previousDay = date - 1

dateNext ++
assert dateNext == nextDay

datePrevious --
assert datePrevious == previousDay

otherDate = Date.parse('yyyy/MM/dd', '1973/07/21') // 07/09 제외
assert 12 == (otherDate..<date).size()
println otherDate..<date

Locale.setDefault(Locale.US)

assert '9 July, 1973' == date.format("d MMMM, yyyy")
assert '7/9/73' == date.getDateString()