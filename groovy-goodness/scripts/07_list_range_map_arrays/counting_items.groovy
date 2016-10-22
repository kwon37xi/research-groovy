// compareTo or equals를 사용해서 아이템 갯수 카운팅

def list = [0, 1, 2, 1, 1, 3, 2, 0, 1]

assert 9 == list.size()
assert 2 == list.count(0)
assert 4 == list.count(1)
assert 2 == list.count(2)
assert 1 == list.count(3)