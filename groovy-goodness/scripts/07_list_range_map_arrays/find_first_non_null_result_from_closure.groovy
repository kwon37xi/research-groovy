def list = ['Groovy', 'Griffon', 'Grails', 'Gradle']

// findResult : closure의 실행결과가 null이 아닌 첫번째 것을 찾아서 리턴함.
assert list.findResult { it.startsWith('Gra') ? it : null } == 'Grails'

// 결과가 없을 경우 기본값 리턴
assert list.findResult('Gr8') { if (it.size() < 6) { "found text with size smaller than 6"} } == 'Gr8'

