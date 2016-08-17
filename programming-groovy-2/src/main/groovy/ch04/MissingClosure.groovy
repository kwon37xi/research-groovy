package ch04

def doSomeThing(closure) {
    if (closure) {
        closure()
    } else {
        println "Using default implementation"
    }
}
doSomeThing() { println "Use specialized implementation"}
doSomeThing()