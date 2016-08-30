/*
@Mixin 애노테이션 deprecated 되었음. trait 권장.
 */
class Friend {
    def listen() {
        "$name is listening as friend"
    }
}

class Teacher {
    def teach() {
        "$name is teaching"
    }
}

/*
혹은
static {
    mixin Friend
}
 */
@Mixin([Friend, Teacher])
class MPerson {
    String firstName
    String lastName
    String getName() {
        "$firstName $lastName"
    }
}

john = new MPerson(firstName: "John", lastName: "Smith")
println john.listen()
println john.teach()

class Dog {
    String name
}

Dog.mixin Friend

buddy = new Dog(name: "Buddy")
println buddy.listen()

class Cat {
    String name
}

try {
    rude = new Cat(name: "Rude")
    rude.listen()
} catch (ex) {
    println ex.message
}

socks = new Cat(name: "Socks")
socks.metaClass.mixin Friend
println socks.listen()