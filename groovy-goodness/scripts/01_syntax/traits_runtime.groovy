trait Name {
    String salutation, firstName, lastName
    String getFullName() {
        [salutation, firstName, lastName].join(' ')
    }
}

class User {
    String username, password
}

def user = new User() as Name // as Name??
user.with {
    salutation = 'Mr.'
    firstName = 'Hubert'
    lastName = 'Klein Ikkink'
    username = 'mrhaki'
    password = '*****'
}

assert user.fullName == 'Mr. Hubert Klein Ikkink'


// withTraits 는 trait이 적용된 새로운 인스턴스를 리턴한다.
trait Id {
    Long id
}

trait Version {
    Long version = 0
}

trait Active {
    Date from = new Date()
    Date to = null

    boolean isActive() {
        final Date now = new Date()
        from < now && (!to || to > now)
    }
}


class Person {
    String username
}

def person = new Person(username: 'mrhaki')
def domainPerson = person.withTraits Id, Version, Active

domainPerson.id = 1
assert domainPerson.username == 'mrhaki'
assert domainPerson.id == 1
assert domainPerson.version == 0
assert domainPerson.active