package ch04

def completeOrder(amount, taxComputer) {
    tax = 0
    if (taxComputer.maximumNumberOfParameters == 2) { // closure의 파라미터 갯수 검사
        tax = taxComputer(amount, 6.05)
    } else {
        tax = taxComputer(amount)
    }

    println "Sales tax is ${tax}"
}

completeOrder(100) { it * 0.0825 }
completeOrder(100) { amount, rate -> amount * (rate / 100) }

