package ch14_metaprogramming
// groovy.runtime.metaclass.[package].[class]MetaClass 이름 규칙을 지키면 커스텀 메타 클래스를 시작 시점에
// 지정할 수 있다.


// String 메타 클래스 추가시에는 groovy.runtime.metaclass.java.lang.StringMetaClass 생성.
// DelegatingMetaClass 상속해서 구현.

assert 'mrhaki'.toUpperCase() == 'MRHAKI'
assert !'Java'.hasGroovy()
assert 'mrhaki loves Groovy'.hasGroovy()
assert 'Groovy'.toLowerCase().hasGroovy()
