package ch03

void givenRaise(Employee employee) {
    employee.raise(new BigDecimal(10000.00))
}

givenRaise new Employee()

// multiple dispatch/multimethods - 메소드 호출이 객체 + 파라미터 조합으로 이루어짐
givenRaise new Executive() // raise(BigDecimal)이 호출된다. 호출시점에 파라미터에 가장 적합한 메소드가 호출된다.