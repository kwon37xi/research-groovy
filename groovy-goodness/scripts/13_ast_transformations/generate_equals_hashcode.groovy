// HashCodeHelper로 생성.
// equals는 모든 프라퍼티 값은지 여부 검사.

// includeFields=true for fields.
// callSuper=true for super class
// excludes='prop,...'

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {
    String name
    boolean active
    List likes
    private int age = 37
}

def user = new User(name: 'mrhaki', active: false, likes: ['Groovy', 'Java'])
def mrhaki = new User(name: 'mrhaki', likes: ['Groovy', 'Java'])
def hubert = new User(name: 'Hubert Klein Ikkink', likes: ['Groovy', 'Java'])


assert user == mrhaki
assert mrhaki != hubert

Set users = new HashSet()
users.add user
users.add mrhaki
users.add hubert

assert users.size() == 2