// Collection.toSpreadMap() : 짝수 인덱스(0,2,4,..) 값은 Key, 홀수 인덱스(1,3,5,...) 값은 value가 된다.

def list = ['key', 'value', 'name', 'mrhaki'] as Object[]
def map = list.toSpreadMap()

assert 2 == map.size()
assert 'value' == map.key
assert 'mrhaki' == map['name']