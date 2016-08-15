package ch02

// groovy 에서 == 는 java에서 1차적으로는 Comparable 인터페이스 구현체일 경우에는 'compareTo', 그렇지 않으면 'equals' 메소드와 같다.
// groovy 에서 'is' 가 java 의 == 와 같다.

str1 = 'hello'
str2 = str1
str3 = new String('hello')
str4 = 'Hello'

println "str1 == str2: ${str1 == str2}" // true
println "str1 == str3: ${str1 == str3}" // true
println "str1 == str4: ${str1 == str4}" // false

println "str1.is(str2): ${str1.is(str2)}" // true
println "str1.is(str3): ${str1.is(str3)}" // false
println "str1.is(str4): ${str1.is(str4)}" // false

strNull = null
println "strNull.is(str1): ${strNull.is(str1)}" // false  - 예외 발생안하고 그냥 false이다.
println "str1.is(strNull): ${str1.is(strNull)}" // false  - 예외 발생안하고 그냥 false이다.