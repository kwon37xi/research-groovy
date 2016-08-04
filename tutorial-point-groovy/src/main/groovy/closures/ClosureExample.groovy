package closures

class ClosureExample {
    static void main(String[] args) {
        def clos = {println "Hello World"}
        clos.call()

        def closWithParams = {param -> println "Hello ${param}"}
        closWithParams.call("World!")

        def closWithImplicitParams = {println "Hello ${it}"}
        closWithImplicitParams.call("World?")

        def str1 = "Hello"
        def closWithVars = {param -> println "${str1} ${param}"}
        closWithVars.call("World")

        str1 = "Welcome"
        closWithVars.call("World")

        display(closWithVars)

        def lst = [11, 12, 13, 14]
        lst.each {println it}

        def map = ["TopicName": "Maps", "TopicDescription": "Methods in maps"]
        map.each {println it}
        map.each {println "${it.key} maps to : ${it.value}"}

        def lst2 = [1,2,3,4]
        lst2.each {println it}
        println("The list will only display those numbers which are divisible by 2")
        lst2.each { num -> if (num % 2 == 0) println num}

        def value
        value = lst2.find {element -> element > 2} // The find method returns the first value found or null if no such element exists.
        println "first value > 2 - ${value}"

        value = lst2.findAll {element -> element > 2}
        value.each {println "all value > 2 - ${it}"}

        println "=== any & every"
        value = lst2.any {element -> element > 2}
        println "any value > 2 ? ${value}"

        value = lst2.any {element -> element > 4}
        println "any value > 4 ? ${value}"

        value = lst2.every { element -> element > 2}
        println "every value > 2 ? ${value}"

        value = [4, 5, 6].every {element -> element > 2}
        println "every value > 2 ? ${value}"

        def newlist = []
        newlist = lst2.collect {element -> return element * element}
        println "collect ${newlist}"
    }

    def static display(clo) {
        clo.call("Inner")
    }
}
