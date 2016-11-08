// java.lang.Appendable
// Writers implement Appendable
// leftShift() : <<
// withFormatter() : Locale을 지정하면 해당 로케일의 Formatter 객체가 생성되어 closure로 넘어옴.

String getNewLine() {
    System.lineSeparator()
}

Date getDate() {
    Date.parse('yyyy-MM-dd', '2013-01-27')
}

String getDatePattern() {
    '%1$tB %1$te, %1$tY%n'
}

final Appendable appendable = new StringWriter()
assert appendable in Appendable

appendable << 'Groovy is Gr8!' << newLine

appendable.withFormatter { Formatter formatter ->
    formatter.format(/m r %3$1s %2$1s %1$1s %4$1s%n/, 'k', 'a', 'h', 'i')
}

appendable.withFormatter(Locale.US) { Formatter formatter ->
    formatter.format("US: " + datePattern, date)
}

appendable.withFormatter(new Locale('nl')) { Formatter formatter ->
    formatter.format("Dutch: $datePattern", date)
}

assert appendable.toString() == '''Groovy is Gr8!
m r h a k i
US: January 27, 2013
Dutch: januari 27, 2013
'''