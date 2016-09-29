// subscript operator []
// getAt() 메소드를 구현하면 [] 연산자를 사용할 수 있게 된다.

def s = 'Accessing Strings in Groovy is easy.'

assert 'A' == s[0]
assert 'A' == s.getAt(0)
assert 'Groovy' == s[21..26]
assert 'easy.' == s[s.indexOf('ea')..-1] // ea 시작부터 끝까지
s[21..26].each {
    print "$it-"
}
