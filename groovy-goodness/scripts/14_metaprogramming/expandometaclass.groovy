// metaClass 객체는 ExpandoMetaClass 인스턴스.
// method(static) 포함, 프라퍼티, 생성자를 metaClass 에 실행시간에 동적으로 추가할 수 있다.

List.metaClass.rightShift {
    delegate.remove it
}

def list = ['one', 'two', 'three', 'four']
assert 4 == list.size()

list.rightShift 'two'
assert 3 == list.size()
assert ['one', 'three', 'four'] == list

list >> 'one'
assert 2 == list.size()
assert ['three', 'four'] == list

// 인스턴스에 메소드 추가

list.metaClass.groovy {
    delegate.collect { it + ' groovy' }
}

assert ['three groovy', 'four groovy'] == list.groovy()

def newList = ['a', 'b']

try {
    newList.groovy()
    assert false
} catch (e) {
    assert e instanceof MissingMethodException
}