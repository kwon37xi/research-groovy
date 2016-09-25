class User {
    String name
    String giveName() { name }
}

def u = new User(name: 'mrhaki')
println u.givenName() // give"n"Name

/*
Caught: groovy.lang.MissingMethodException: No signature of method: User.givenName() is applicable for argument types: () values: []
Possible solutions: giveName(), getName(), setName(java.lang.String)
groovy.lang.MissingMethodException: No signature of method: User.givenName() is applicable for argument types: () values: []
Possible solutions: giveName(), getName(), setName(java.lang.String)
 */