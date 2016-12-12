/*
script 에서 변수 선언시, def/클래스타입 으로 선언할 때와 아무것도 없이 변수를 바로 선언할 때 행위가 다르다.
아무것도 없이 선언해야, script 안에서 선언된 메소드에서 접근 가능하다.

단, @Field  를 사용하면 def/클래스타입 선언도 접근 가능해진다.
change_scope_script_variable_with_field_annotation.groovy 참조.
 */

String s = 'I am in local scope' // script 내에서 선언된 메소드에서 접근 불가
def i = 42 // script 내에서 선언된 메소드에서 접근 불가
counter = 0 // script 내에서 선언된 메소드에서 접근 가능

def runIt() {
    try {
        assert 'A am in local scope.' == s
        assert false
    } catch (e) {
        assert e instanceof MissingPropertyException
    }

    try {
        assert 42 == i
        assert false
    } catch (e) {
        assert e instanceof MissingPropertyException
    }

    assert 0 == counter++
}

runIt()

assert 'I am in local scope' == s
assert 42 == i
assert 1 == counter