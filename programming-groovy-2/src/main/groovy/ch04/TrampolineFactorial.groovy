package ch04

/*
재귀호출은 반복문으로 전환 가능하다.

이를 컴파일러 차원에서 하면 재귀호출의 간결함을 유지하면서
반복문으로 자동 전환되어 StackOverFlow 없는 코딩이 가능해진다. -> 꼬리 재귀(tail recursion)

closure trampoline 을 사용한다.
 */

def factorial

factorial = { int number, BigInteger theFactorial ->
    number == 1 ? theFactorial : factorial.trampoline(number - 1, number * theFactorial)
}.trampoline()

println "factorial of 5 is ${factorial(5, 1)}"
println "Number of bits in the result is ${factorial(5000, 1).bitCount()}"

def iterFactorial(int number) {
    BigInteger fac = 1

    for (;number > 1; number--) {
        fac *= number
    }

    return fac
}

println "iterFactorial of 5 is ${iterFactorial(5)}"
println "iterFactorial Number of bits in the result is ${iterFactorial(5000).bitCount()}"