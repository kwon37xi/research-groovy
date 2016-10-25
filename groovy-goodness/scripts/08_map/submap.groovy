// subMap()

def map = [name: 'mrhaki', country: 'The Netherlands', blog: true, languages: ['Groovy', 'Java']]

// 컬렉션에 있는 키 엔트리만을 뽑아서 새로운 맵을 만듬.
def keys = ['name', 'blog']
assert [name: 'mrhaki', blog: true] == map.subMap(keys)

def booleanKeys = map.findAll { it.value instanceof Boolean }.collect { it.key }
assert [blog: true] == map.subMap(booleanKeys)

def words = ['a': 'Apple', 'j': 'Java', 'g': 'Groovy', 'c': 'Cool']
def range = 'c'..'h' // a, j 제외

// subMap()은 존재하지 않는 key 에 대해서도 value를 null로 리턴한다.
// 그래서 findAll로 null value 필터링
def rangeWords = words.subMap(range).findAll { it.value }

assert ['c': 'Cool', 'g': 'Groovy'] == rangeWords