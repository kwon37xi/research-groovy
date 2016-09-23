class User {
    String name
    String email
    String password

    Object getProperty(String propertyName) {
        println "user getProperty"
        "mrhaki"
    }
        String displayName() {
        name
    }
}



class UserProxy extends groovy.util.Proxy {
    List fields

    // override getProperty
    Object getProperty(String propertyName) {
        def adt = super.getProperty("adaptee")
        if (prepertyName in fields) {
            adt.getProperty(propertyName)
        } else {
            throw new MissingPropertyException("Unknown property ${propertyName}")
        }
    }
}

def user = new User(name: 'mrhaki', email: 'private@localhost', password: 'secret')
assert 'mrhaki' == user.name

def userProxy = new UserProxy(fields: ['name']).wrap(user)
println user.dump()
println "just before userProxy.name"
assert 'mrhaki' == userProxy.name

println 'another next'
try {
    userProxy.email
    assert false
} catch (MissingPropertyException e) {
    assert 'Unknown property email' == e.message
}

assert 'mrhaki' == userProxy.displayName()