abstract class Person {
    String name
}

class Parent extends Person {}

class Child extends Person {}

def printName(Person person) {
    "printName(Person): $person.name"
}

def printName(Child child) {
    "printName(Child): $child.name"
}

def printName(p) { "printName(p): $p.name" }

Person parent1 = new Parent(name: 'parent1')
Person child1 = new Child(name: 'child1')

assert 'printName(Person): parent1' == printName(parent1) // Parent에 대한 printName은 정의한 적 없음.

assert 'printName(Child): child1' == printName(child1)  // java에서는 Person 으로 나옴.

assert 'printName(Person): child1' == printName(child1 as Person)

Parent parent2 = new Parent(name: 'parent2')
Child child2 = new Child(name: 'child2')

assert "printName(Person): parent2" == printName(parent2)
assert 'printName(Child): child2' == printName(child2)

class Dog {
    String name
}

assert 'printName(p): buck' == printName(new Dog(name: 'buck'))