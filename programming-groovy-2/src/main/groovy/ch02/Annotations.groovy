package ch02

import groovy.transform.*

@Canonical(excludes = "lastName, age")
class Person {
    String firstName
    String lastName
    int age
}

def sara = new Person(firstName: "Sara", lastName: "Walker", age: 49)

println sara

class Worker {
    def work() { println 'get work done' }
    def analyze() { println 'analyze...'}
    def writeReport() { println 'get report written' }
}

class Expert {
    def analyze() { println 'expert analysis...' }
}

// Delegate 로 메소드를 가져올 때는, 현재 클래스에 메소드 선언이 없을 때만.
class Manager {
    @Delegate Expert expert = new Expert()
    @Delegate Worker worker = new Worker()
}

def bernie = new Manager()
bernie.analyze()// from expert
bernie.work()
bernie.writeReport()

@Immutable // equals, hashCode, toString, 생성자 생성
class CreditCard {
    String cardNumber
    int creditLimit
}

println new CreditCard("4000-1111-2222-3333", 1000)

class Heavy {
    def size = 10
    Heavy() {
        println "Creating Heavy with $size"
    }
}

class AsNeeded {
    def value

    @Lazy Heavy heavy1 = new Heavy()
    @Lazy Heavy heavy2 = {new Heavy(size: value) }() // make volatile

    AsNeeded() { println "Created AsNeeded"}
}
def asNeeded = new AsNeeded(value: 1000) // 생성자에 named parameter를 넣는것은 기본 생성자 호출 -> setter 호출 형태로 이뤄짐.
println asNeeded.heavy1.size // 10
println asNeeded.heavy1.size // 10
println asNeeded.heavy2.size // 1000