package ch07

class Person {
    def walk() { println "Walking..." }
    def walk(int miles) { println "Walking $miles miles"}
    def walk(int miles, String where) { println "Walking $miles miles $where..."}
}

peter = new Person()

peter.invokeMethod("walk", null)
peter.invokeMethod("walk", 10)
peter.invokeMethod("walk", [2, 'uphill'] as Object[])