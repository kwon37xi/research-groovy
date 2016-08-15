package ch02

class A {
    boolean equals(other) {
        println "equals called"
        false
    }
}

class B implements Comparable {
    boolean equals(other) {
        println "equals called"
        false
    }

    int compareTo(other) {
        println "compareTo called"
        0
    }
}

println new A() == new A()
println new B() == new B()