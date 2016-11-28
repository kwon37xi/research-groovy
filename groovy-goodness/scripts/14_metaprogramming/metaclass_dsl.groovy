// 하나의 메소드에 여러 overloading을 할 때는 << 사용.
String.metaClass {

    // | 연산자
    or << { String s -> delegate.plus(' or ').plus(s)}

    or << { List l -> delegate.findAll("(${l.join('|')})")}


    // & 연산자 단일 메소드 지정
    and { String s -> delegate.plus(' and ').plus(s) }

    // static 메소드 추가
    'static' {
        groovy { 'Yeah man!'}
    }
}

assert ("Groovy" | "Java?") == 'Groovy or Java?'
assert ("Groovy" | ['o', 'y']) == ['o', 'o', 'y'] // list에 있는 문자와 매치되는 모든 문자 찾기인듯.
assert ("Groovy" & "Java!") == 'Groovy and Java!'

assert String.groovy() == 'Yeah man!'
