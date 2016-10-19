// unique()는 List 원본을 변경시킨다.

class User implements Comparable<User> {
    String username, email
    boolean active

    @Override
    int compareTo(User o) {
        username <=> o.username
    }
}

def mrhaki1 = new User(username: 'mrhaki', email: 'mrhaki@localhost', active: false)
def mrhaki2 = new User(username: 'mrhaki', email: 'user@localhost', active: true)
def hubert1 = new User(username: 'hubert', email: 'user@localhost', active: false)
def hubert2 = new User(username: 'hubert', email: 'hubert@localhost', active: true)

// with Comparable
def uniqueUsers = [mrhaki1, mrhaki2, hubert1, hubert2].unique()
assert 2 == uniqueUsers.size()
assert [mrhaki1, hubert1] == uniqueUsers

// with 1 parameter closure : 리턴된 값을 Compare 기준으로 삼음
def uniqueEmail = [mrhaki1, mrhaki2, hubert1, hubert2].unique { user -> user.email }
assert 3 == uniqueEmail.size()
assert [mrhaki1, mrhaki2, hubert2] == uniqueEmail

// with 2 parameter closure : 비교 결과를 compareTo 처럼 리턴해줘야한다.
def uniqueActive = [mrhaki1, mrhaki2, hubert1, hubert2].unique { u1, u2 -> u1.active <=> u2.active }
assert 2 == uniqueActive.size()
assert [mrhaki1, mrhaki2] == uniqueActive

// with Comparator
def emailComparator = [
        equals: { delegate.equals(it) },
        compare: { first, second ->
            first.email <=> second.email
        }
] as Comparator

def unique = [mrhaki1, mrhaki2, hubert1, hubert2].unique(emailComparator)
assert 3 == unique.size()
assert [mrhaki1, mrhaki2, hubert2] == unique
unique.each { println(it.email) }