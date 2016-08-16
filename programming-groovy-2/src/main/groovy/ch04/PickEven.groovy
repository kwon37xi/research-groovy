package ch04

// pickEven higher-order function 고차함수. 함수를 인자로 받거나 함수를 리턴하는 함수
def pickEven(n, block) {
    for(int i = 2; i <= n; i += 2) {
        block(i)
    }
}

pickEven(10, { println it })

// closure가 마지막 인자일 때
pickEven(10) { evenNumber ->
    println evenNumber
}

total = 0

pickEven(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"

product = 1
pickEven(10) { product *= it }
println "Product of even numbers from 1 to 10 is ${product}"