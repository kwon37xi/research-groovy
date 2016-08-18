package ch04

def factorial(BigInteger number) {
    if (number == 1) 1 else number * factorial(number - 1)
}

try {
    println "factorial of 5 is ${factorial(5)}"
    println "Number of bits in the result is ${factorial(5000).bitCount()}" // stackoverflow
} catch (Throwable ex) {
    println "Caught ${ex.class.name}"
}
