def list = ['Daffy', 'Bugs', 'Elmer', 'Tweety', 'Silvester', 'Yosemite']

assert 'Bugs' == list.find { it == 'Bugs' }

assert ['Daffy', 'Bugs', 'Elmer'] == list.findAll { it.size() < 6 }

assert 1 == list.findIndexOf { name -> name =~ /^B.*/ }

assert 4 == list.findIndexOf(3) { it[0] == 'S'  } // S 로 시작하는 문자열을 3번째값부터 탐색시작

assert [0, 3, 5] == list.findIndexValues { it =~ /(y|Y)/ } // y/Y를 포함한 문자열 탐색

assert [3, 5] == list.findIndexValues(2) { it =~ /(y|Y)/ }

assert 2 == list.findLastIndexOf { it.size() == 5 }

assert 5 == list.findLastIndexOf(1) { it.count('e') > 1 } // 알파벳 'e'가 1개 이상들어간 것을

assert list.any { it =~ /a/ } // a 문자를 포함한 문자열이 하나라도 존재하나?

assert list.every { it.size() > 3} // 모든 문자열이 3글자 초과인가?

def map = [name: 'Message from mrhaki', url: 'http://mrhaki.blogspot.com', blog: true]

def found = map.find { key, value -> key == 'name' } // 키가 'name' 인 엔트리 찾기
assert found.key == 'name' && found.value == 'Message from mrhaki'

assert [name: 'Message from mrhaki', url: 'http://mrhaki.blogspot.com'] == map.findAll { key, value -> value =~ /mrhaki/ }

assert 1 == map.findIndexOf { it.value.endsWith('com') }
assert [1, 2] == map.findIndexValues { it.key =~ /l/ } // key 에 소문자 l 들어간거

assert 2 == map.findLastIndexOf { it.key =~ /l/ && it.value }

assert map.any { entry -> entry.value }

assert map.every { key, value -> key.size() >= 3 }
