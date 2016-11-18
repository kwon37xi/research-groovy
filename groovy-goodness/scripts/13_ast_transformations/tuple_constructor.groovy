// @TupleConstructor : 필드 생성 순서대로 생성자 만들기

import groovy.transform.TupleConstructor

@TupleConstructor
class Person {
    String name
    List likes
    private boolean active = false
}

def person = new Person('mrhaki', ['Groovy', 'Java']) // 필드 선언 순서 대로 생성자 만들어짐.

assert person.name == 'mrhaki'
assert person.likes == ['Groovy', 'Java']

person = new Person('mrhaki')
assert person.name == 'mrhaki'
assert !person.likes

@TupleConstructor(includeFields = true)
class Person2 {
    String name
    List likes
    private boolean active = false

    boolean isActivated() { active }
}

person = new Person2('mrhaki', ['Groovy', 'Java'], true)

assert person.name == 'mrhaki'
assert person.likes == ['Groovy', 'Java']
assert person.activated

// use force attribute to force creation of constructor
// even if we define our own constructors.

@TupleConstructor(force = true)
class Person3 {
    String name
    List likes
    private boolean active = false

    Person3(boolean active) {
        this.active = active
    }

    boolean isActivated() { active }
}

person = new Person3('mrhaki', ['Groovy', 'Java'])
assert person.name == 'mrhaki'
assert person.likes == ['Groovy', 'Java']
assert !person.activated

person = new Person3(true)

assert person.activated

@TupleConstructor(includeFields = true)
class Person4 {
    String name
    List likes
    private boolean active = false

    boolean isActivated() { active }
}

@TupleConstructor(callSuper = true, includeSuperProperties = true, includeSuperFields = true)
class Student extends Person4 {
    List courses
}

def student = new Student('mrhaki', ['Groovy', 'Java'], true, ['IT'])

assert student.name == 'mrhaki'
assert student.likes == ['Groovy', 'Java']
assert student.activated
assert student.courses == ['IT']