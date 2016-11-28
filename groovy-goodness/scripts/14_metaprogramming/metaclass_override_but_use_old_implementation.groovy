// metaClass로 override를 하지만 때로는 기존 구현을 사용해야 할 때,
// 변수에 기존 메소드를 저장해둔다.
// metaClass.getMetaMethod()를 사용한다.

def savedToUpperCase = String.metaClass.getMetaMethod('toUpperCase', [] as Class[])

String.metaClass.toUpperCase = { ->
    def result = savedToUpperCase.invoke(delegate)
    if (delegate =~ /Groovy/) {
        result + ' Oh, yeah man! Groooovy....'
    } else {
        result
    }
}

assert 'A simple string'.toUpperCase() == 'A SIMPLE STRING'
assert 'This is Groovy.'.toUpperCase() == 'THIS IS GROOVY. Oh, yeah man! Groooovy....'
