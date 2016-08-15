package ch03;

import java.math.BigDecimal;

public class GivenRaiseJava {
    // Employee 와 그 상속자들을 받음
    public static void givenRaise(Employee employee) {
        employee.raise(new BigDecimal(10000.00)); // Employee.raise(Number)만 호출됨.
    }

    public static void main(String[] args) {
        givenRaise(new Employee());
        givenRaise(new Executive()); // 여기서도 raise(Number)만 호출된다. givenRaise가 인자로 Employee를 받기 때문.
    }
}
