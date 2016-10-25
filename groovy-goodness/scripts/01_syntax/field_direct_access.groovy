/*
Groovy Goodness: Direct Field Access In (Super) Classes
http://mrhaki.blogspot.kr/2016/10/groovy-goodness-direct-field-access-in.html
 */

class Person {
    protected String name

    String getName() {
        "_${name}_"
    }

    void setName(String name) {
        this.name = "*${name}*"
    }
}

class User extends Person {
    String getUsername() {
        "User(${this.name})"
    }

    String getUsernameField() {
        "User(${this.@name})"
    }
}

def u = new User(name: 'mrhaki')
assert u.username == 'User(_*mrhaki*_)' // setName/getName/getUsername 함께 호출됨.
assert u.usernameField == 'User(*mrhaki*)' // getName 호출안함.
assert u.name == '_*mrhaki*_'
assert u.@name == '*mrhaki*'

u.@name = 'mrhaki'

assert u.username == 'User(_mrhaki_)' // getName/getUsername
assert u.usernameField == 'User(mrhaki)' // getUsernameField
assert u.name == '_mrhaki_'
assert u.@name == 'mrhaki'