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

    def analyze() { println 'analyze...' }

    def writeReport() { println 'get report written' }
}

class Expert {
    def analyze() { println 'expert analysis...' }
}

// Delegate 로 메소드를 가져올 때는, 현재 클래스에 메소드 선언이 없을 때만.
class Manager {
    @Delegate
    Expert expert = new Expert()
    @Delegate
    Worker worker = new Worker()
}

def bernie = new Manager()
bernie.analyze()// from expert
bernie.work()
bernie.writeReport()

@Immutable
// equals, hashCode, toString, 생성자 생성
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

    @Lazy
    Heavy heavy1 = new Heavy()
    @Lazy
    Heavy heavy2 = { new Heavy(size: value) }() // make volatile

    AsNeeded() { println "Created AsNeeded" }
}

def asNeeded = new AsNeeded(value: 1000) // 생성자에 named parameter를 넣는것은 기본 생성자 호출 -> setter 호출 형태로 이뤄짐.
println asNeeded.heavy1.size // 10
println asNeeded.heavy1.size // 10
println asNeeded.heavy2.size // 1000

@Newify([Person, CreditCard])
def fluentCreate() {
    println Person.new(firstName: 'John', lastName: 'Doe', age: 20) // new 함수
    println Person(firstName: 'John', lastName: 'Doe', age: 20) // new 없이
    println CreditCard('1234-5678-1234-5678', 2000)
}

fluentCreate()

// lazy = true 이기 때문에 getInstance() 를 호출할 때까지 객체 생성 보류
// GroovyConsole script -> Inspect AST -> Canonicalization 을 보면 실제로 생성된 최종 소스를 볼 수 있다.
@Singleton(lazy = true, strict = false)
class TheUnique {
    // strict=false가 아니면 별도 생성자를 둘 수 없다.
    private TheUnique() {
        println 'Instance created'
    }

    def hello() {
        println 'hello'
    }
}

println 'Accessing TheUnique'
TheUnique.instance.hello()
TheUnique.instance.hello()

@InheritConstructors
class SomeException extends RuntimeException {

}

def someEx = new SomeException("Hello this is an error.", new Exception("some cause")) // 생성자가 자동으로 만들여졌음.
someEx.printStackTrace()