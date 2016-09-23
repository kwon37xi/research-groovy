class User {
    String name
    String email
    String password

    String displayName() {
        name
    }
}


class UserProxy extends groovy.util.Proxy {
    List fields

    Object getProperty(String propertyName) {
        // 일부 환경에서 propertyName in fields가 다시 getProperty("fields")를 호출하여 StackOverflow를 냈음.
        // fields.contains(propertyName)로 변경하니까 됐음.
        getAdaptee().getProperty(propertyName)
        if (propertyName in fields) {
        } else {
            throw new MissingPropertyException("Unknown property ${propertyName}")
        }
    }
}

def user = new User(name: 'mrhaki', email: 'private@localhost', password: 'secret')
assert 'mrhaki' == user.name

def userProxy = new UserProxy(fields: ['name']).wrap(user)
assert 'mrhaki' == userProxy.name

try {
    userProxy.email
    assert false
} catch (MissingPropertyException e) {
    assert 'Unknown property email' == e.message
}

assert 'mrhaki' == userProxy.displayName()