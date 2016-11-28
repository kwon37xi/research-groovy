// 클래스의 metaClass 프라퍼티를 통해 새로운 메소드를 추가하거나 기존 메소드를 오버라이드할 수 있다.
// 이미 존재하는 이름에 인자만 다른 메소드를 추가하려면 leftShift << 연산자를 사용한다.

String.metaClass.groovy << { Integer number ->
    delegate * number
} << { String s ->
    delegate + s
} << { ->
    delegate + ' Groovy rocks.'
}

assert 'Groovy'.groovy(2) == 'GroovyGroovy'
assert 'Hello world'.groovy(' from Groovy') == 'Hello world from Groovy'
assert 'It is true.'.groovy() == 'It is true. Groovy rocks.'