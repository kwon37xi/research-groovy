package ch04

def examine(closure) {
    println "$closure.maximumNumberOfParameters parameter(s) given:"
    for (aParameter in closure.parameterTypes) {
        println aParameter.name
    }
    println "--"
}
examine() {} // 1 parameter
examine() { it } // 1 parameter
examine() { -> } // no parameter
examine() { val1 -> }
examine() { Date val1 -> }
examine() { Date val1, val2 -> }
examine() { Date val1, String val2 -> }