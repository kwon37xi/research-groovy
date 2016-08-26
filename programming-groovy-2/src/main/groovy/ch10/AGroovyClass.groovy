package ch10

class AGroovyClass {
    def useClosure(closure) {
        println "Calling closure"
        closure()
    }

    def passToClosure(int value, closure) {
        println "Simply passing $value to the given closure"
        closure(value)
    }
}
