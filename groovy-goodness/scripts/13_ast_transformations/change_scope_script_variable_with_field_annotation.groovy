// 스크립트 변수의 스코프는 타입 선언을 추가하는 순간 변한다.
// 그리고는 해당 변수는 더이상 스크립트의 메소드에서는 접근할 수 없다.
// 변수를 스코프의 모든 영역에서 접근하려면 @Field 애노테이션을 한다.
// 이 방식으로 타입과 스크립트에서 메소드를 갖는게 모두 가능해진다.

import groovy.transform.Field

// script 메소드에서 접근 불가
String stringValue = 'I am typed without @Field.'
def i = 42

// script 메소드에서 접근 가능
@Field String stringField = 'I am typed with @Field.'
counter = 0 // 타입 선언 없어도 전역으로 접근 가능.

def runIt() {
    try {
        assert stringValue == 'I am typed without @Field.'
    } catch (e) {
        assert e instanceof MissingPropertyException
    }

    try {
        assert i == 42
    } catch (e) {
        assert e instanceof MissingPropertyException
    }

    assert stringField == 'I am typed with @Field.'
    assert counter++ == 0
}

runIt()

// 메소드 밖에서는 모두 접근가능
assert stringValue == 'I am typed without @Field.'
assert stringField == 'I am typed with @Field.'
assert i == 42
assert counter == 1