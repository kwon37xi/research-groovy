package ch04

// tail recursion 에서 잘못된 인자를 넘길 수 있는 오류를
// 함수로 감싸서 해결한다.

def factorial(int factorialFor) {
    def tailFactorial

    tailFactorial = { int number, BigInteger theFactorial = 1 ->
        number == 1 ? theFactorial : tailFactorial.trampoline(number - 1, number * theFactorial)
    }.trampoline()
    tailFactorial(factorialFor)
}

println "factorial of 10 is ${factorial(10)}"
println "Number of bits in the result is ${factorial(5000).bitCount()}"

// trampoline은 컴파일러 최적화가 아니라, 그냥 closure의 기능이다.
// 이로인해 trampoline은 단순한 재귀호출이나 순수 반복문보다 느리다.
