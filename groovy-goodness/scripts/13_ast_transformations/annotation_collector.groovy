import groovy.transform.AnnotationCollector
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@AnnotationCollector([EqualsAndHashCode, ToString])
@interface Simple {}

@Simple
class User {
    String username
    int age
}

def user = new User(username: 'mrhaki', age: 39)

assert user.toString() == 'User(mrhaki, 39)'

assert User.class.annotations.size() == 2

// use attributes from groupd annotations
@Simple(excludes = 'street')
class Address {
    String street, town
}

def address = new Address(street: 'Evergreen Terrace', town: 'Springfield')
assert address.toString() == 'Address(Springfield)'

@EqualsAndHashCode
@ToString
@AnnotationCollector
@interface Simple2 {}

@Simple2
class User2 {
    String username
}

def user2 = new User2(username: 'mrhaki2')
assert user2.toString() == 'User2(mrhaki2)'