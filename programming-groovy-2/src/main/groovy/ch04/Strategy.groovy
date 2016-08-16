package ch04

def totalSelectValues(n, closure) {
    total = 0
    for (i in 1..n) {
        if (closure(i)) { total += i }
    }
    total
}


print "Total of even numbers from 1 to 10 is "
println totalSelectValues(10) {
    it % 2 == 0
}

def isOdd = { it % 2 != 0}
println "Total of odd numbers from 1 to 10 is ${totalSelectValues(10, isOdd)}"