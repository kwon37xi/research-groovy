// how to create java.util.regex.Matcher
// use =~
// 매칭 결과를 배열 형태로 접근가능.
// group 매칭 결과를 2차원 배열 형태로 접근 가능.
// =~ 연산 결과는 Matcher 객체지만 조건문에서는 boolean으로 변환됨.

// ==~ : exact match - boolean

def finder = ('groovy' =~ /gr.*/)
assert finder instanceof java.util.regex.Matcher
def matcher = ('groovy' ==~ /gr.*/)
assert matcher instanceof Boolean

// =~ in conditional context returns boolean
assert 'Groovy rocks!' =~ /Groovy/
assert !('Groovy rocks!' ==~ /Groovy/)
assert 'Groovy rocks!' ==~ /Groovy.*/

def cool = /gr\w{4}/
def findCool = ('groovy, java and grails rock!' =~ /$cool/)
assert 2 == findCool.count // 2 개 매칭됨
assert 2 == findCool.size()
assert 'groovy' == findCool[0]
assert 'grails' == findCool.getAt(1)

// grouping - multidemensional array
def group = ('groovy and grails, ruby and rails' =~ /(\w+) and (\w+)/)
assert group.hasGroup()
assert 2 == group.size()
assert ['groovy and grails', 'groovy', 'grails'] == group[0] // group[0] is an array
assert 'rails' == group[1][2]

// matcher로 replace하기
assert 'Hi world' == ('Hello world' =~ /Hello/).replaceFirst('Hi')

// Groovy matcher syntax can be used in other methods
assert ['abc'] == ['def', 'abc', '123'].findAll { it =~ /abc/ }
assert [false, false, true] == ['def', 'abc', '123'].collect { it ==~ /\d{3}/ }