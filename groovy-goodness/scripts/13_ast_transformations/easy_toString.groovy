// @ToString
// 기본적으로는 값만 출력됨.
// includeNames=true : 필드명도 출력
// 기본은 프라퍼티(getter/setter)만 되지만 includeFields=true로 필드도 가능.
// excludes='제외할프라퍼티명,...'
// includeSuper=true : 부모클래스 프라퍼티까지 포함.

import groovy.transform.ToString

@groovy.transform.ToString
class Person {
    String name
    List likes
    private boolean active = false // only field
}

def person = new Person(name: 'mrhaki', likes: ['Groovy', 'Java'])
println person.toString()
assert person.toString() == 'Person(mrhaki, [Groovy, Java])' // active 빠짐

@groovy.transform.ToString(includeNames = true)
class Person2 {
    String name
    List likes
    private boolean active = false
}

person = new Person2(name: 'mrhaki', likes: ['Groovy', 'Java'])
println person.toString()
assert person.toString() == 'Person2(name:mrhaki, likes:[Groovy, Java])'

@ToString(includeNames = true, includeFields = true)
class Person3 {
    String name
    List likes
    private boolean active = false
}

person = new Person3(name: 'mrhaki', likes: ['Groovy', 'Java'])
println person.toString()
assert person.toString() == 'Person3(name:mrhaki, likes:[Groovy, Java], active:false)'

@ToString(includeSuper = true, includeNames = true)
class Student2 extends Person2 {
    List courses
}

def student = new Student2(name: 'mrhaki', likes: ['Groovy', 'Java'], courses: ['IT', 'Business'])
println student.toString()
assert student.toString() == 'Student2(courses:[IT, Business], super:Person2(name:mrhaki, likes:[Groovy, Java]))'

@ToString(includeNames = true, includeFields = true, excludes = 'active,likes')
class Person4 {
    String name
    List likes
    private boolean active = false
}

person = new Person4(name: 'mrhaki', likes: ['Groovy', 'Java'])
println person.toString()
assert person.toString() == 'Person4(name:mrhaki)'
