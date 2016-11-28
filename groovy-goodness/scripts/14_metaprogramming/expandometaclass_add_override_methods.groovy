// leftShift(<<) 연산자로 ExpandoMetaClass에 새로운 메소드 추가 가능.
// 메소드가 이미 존재하면 오류 발생.
// 기존 것 덮어쓰려면 equal operator(=) 사용.
// = 는 새 메소드 추가용도로도 사용가능. 하지만 이미 존재하는 메소드를 덮어써도 에러 안남.

Integer.metaClass.eights << { delegate * 8 }
assert 4.eights() == 32

Integer.metaClass.hundreds = { delegate * 100 }
assert 2.hundreds() == 200

// 덮어쓰기 방지
try {
    Integer.metaClass.toString << { 'Groovy' }
    assert false
} catch (e) {
    assert e.message == 'Cannot add new method [toString] for arguments [[]]. It already exists!'
}

Integer.metaClass.toString = { 'Groovy' } // 덮어써짐.
assert 100.toString() == 'Groovy'