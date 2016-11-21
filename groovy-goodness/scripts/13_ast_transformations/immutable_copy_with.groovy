import groovy.transform.Immutable

// @Immutable.copyWith = true 이면 copyWith() 메소드가 생성된다.
// 기본적으로는 기존 프라퍼티 값을 그대로 복사하면서 파라미터로 넘ᅟ긴 Map의 프라퍼티 값은 갱신해서 리턴한다.

@Immutable(copyWith = true)
class User {
    String name
    String email
}

def mrhaki = new User('mrhaki', 'mrhaki@mrhaki.com')

mrhaki.with {
    assert name == 'mrhaki'
    assert email == 'mrhaki@mrhaki.com'
}

def hubert = mrhaki.copyWith(name: 'Hubert A. Klein Ikkink')
hubert.with {
    assert name == 'Hubert A. Klein Ikkink'
    assert email == 'mrhaki@mrhaki.com'
}

try {
    hubert.email = 'new-mail@host.nl'
    assert false
} catch (ReadOnlyPropertyException e) {
    assert 'Cannot set readonly property: email for class: User' == e.message
}