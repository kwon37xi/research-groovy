def list = ['Simple', 'list', 'with', 5, 'items']

assert list.take(1) == ['Simple']
assert list.take(2) == ['Simple', 'list']
assert list.take(0) == []

// 실제 사이즈보다 크게 요청하면 리스트 전체 반환
assert list.take(6) == ['Simple', 'list', 'with', 5, 'items']

// drop() 은 해당 갯수를 제거한 신규 리스트 생성해서 리턴
assert list.drop(1) == ['list', 'with', 5, 'items']
assert list.drop(5) == []
assert list.drop(0) == ['Simple', 'list', 'with', 5, 'items']
assert list == ['Simple', 'list', 'with', 5, 'items']

def array = ['Rocks on!', 'Groovy baby!'] as String[]
assert array.take(1) == ['Rocks on!'] as String[]
assert array.drop(1) == ['Groovy baby!'] as String[]

def range = 0..10
assert range.take(2) == [0, 1]
assert range.take(4) == 0..3
assert range.drop(5) == 5..10

def map = [1: 'one', 2: 'two', 3: 'three']
assert map.take(2) == [1: 'one', 2: 'two']
assert map.drop(2) == [3: 'three']
assert map.drop(3) == [:]

def s = 'Hello Groovy world!'
assert s.take(5) == 'Hello'
assert s.drop(6) == 'Groovy world!'