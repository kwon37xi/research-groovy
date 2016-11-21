import groovy.transform.Immutable

// Immutable 객체는 생성 뒤 변경될 수 없다.
// 동시성 작업과 함수형 프로그래밍에서 유용하다.
// 모든 프라퍼티를 read only로 만든다.(setter 없게)
// 오직 생성자만이 값을 설정할 수 있다.

@Immutable
class User {
    String username, email
    Date created = new Date()
    Collection roles
}

def first = new User(username: 'mrhaki', email: 'email@host.com', roles: ['admin', 'user'])
assert 'mrhaki' == first.username
assert 'email@host.com' == first.email
assert ['admin', 'user'] == first.roles
assert (new Date() + 7).after(first.created)

try {
    first.username = 'new username'
    assert false
} catch (ReadOnlyPropertyException e) {
    assert 'Cannot set readonly property: username for class: User' == e.message
}

// 컬렉션도 변경 불가
try {
    first.roles << 'new role'
    assert false
} catch (UnsupportedOperationException e) {
    assert true
}

def date = new Date(109, 8, 16)
def second = new User('user', 'test@host.com', date, ['user'])
assert 'user' == second.username
assert 'test@host.com' == second.email
assert ['user'] == second.roles
assert '2009/09/16' == second.created.format('yyyy/MM/dd')
assert date == second.created

// Date, Clonabled, arrays는 deep copy된다.
assert !date.is(second.created) // 값은 같지만 동일 객체 아님.

// toString() 도 생성해준다.
assert 'User(user, test@host.com, Wed Sep 16 00:00:00 KST 2009, [user])' == second.toString()

def third = new User(username: 'user', email: 'test@host.com', created: date, roles: ['user'])

// equals()도 생성된다. 프라퍼티 값기반.
assert third == second
assert third != first
