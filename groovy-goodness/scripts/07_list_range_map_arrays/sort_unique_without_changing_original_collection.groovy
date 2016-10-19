// 원본 컬렉션 수정없이 sort/unique
// sort,unique,reverse 에 boolean으로 원본 변경 여부를 지정할 수 있게되었다.

class User implements Comparable {
    String username, email
    boolean active

    int compareTo(Object other) {
        username <=> other.username
    }

    String toString() {
        "[User:$username,$email,$active]"
    }
}

def mrhaki1 = new User(username: 'mrhaki', email: 'mrhaki@localhost', active: false)
def mrhaki2 = new User(username: 'mrhaki', email: 'user@localhost', active: true)
def hubert1 = new User(username: 'hubert', email: 'user@localhost', active: false)
def hubert2 = new User(username: 'hubert', email: 'hubert@localhost', active: true)

def users = [mrhaki1, mrhaki2, hubert1, hubert2]

/* Sort */
def sortedUsers = users.sort(mutate = false)
assert sortedUsers == [hubert1, hubert2, mrhaki1, mrhaki2]
assert users == [mrhaki1, mrhaki2, hubert1, hubert2]

sortedUsers = users.sort() // default behavior mutate=true
assert sortedUsers == [hubert1, hubert2, mrhaki1, mrhaki2]
assert users == [hubert1, hubert2, mrhaki1, mrhaki2]

/* Unique */
def uniqueUsers = users.unique(mutate = false)
assert uniqueUsers == [hubert1, mrhaki1]
assert users == [hubert1, hubert2, mrhaki1, mrhaki2]

uniqueUsers = users.unique() // default behavior mutate=true
assert uniqueUsers == [hubert1, mrhaki1]
assert users == [hubert1, mrhaki1]

/* Reverse */
def reverseUsers = users.reverse() // default behavior mutate = false
assert reverseUsers == [mrhaki1, hubert1]
assert users == [hubert1, mrhaki1]

reverseUsers = users.reverse(mutate = true)
assert reverseUsers == [mrhaki1, hubert1]
assert users == [mrhaki1, hubert1]