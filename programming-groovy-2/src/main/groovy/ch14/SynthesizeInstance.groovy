class Person6 { }

def emc = new ExpandoMetaClass(Person6)

emc.methodMissing = { String name, args ->
    "I'm Jack of all trades... I can $name"
}

emc.initialize()

def jack = new Person6()
def paul = new Person6()

jack.metaClass = emc

println jack.sing()
println jack.dance()
println jack.juggle()

try {
    paul.sing()
} catch(ex) {
    println ex
}