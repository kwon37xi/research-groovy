// ObjectGraphBuilder : Java Beans 규칙을 따르는 객체 그래프를 구성할 수 있다.
// http://docs.groovy-lang.org/2.4.7/html/gapi/groovy/util/ObjectGraphBuilder.html

class School {
    String name
    List<Course> courses = []
}

class Course {
    String name
    Teacher teacher
    List<Student> students = []
}

class Teacher {
    String name
}

class Student {
    String name
}

// Groovy Console에서는 classLoader 지정필요.
def builder = new ObjectGraphBuilder(classLoader: getClass().getClassLoader())

School firstSchool = builder.school(name: 'First School') {
    course(name: 'Math') {
        teacher(name: 'Matt')
        student(name: 'Mary', id: 'Mary')
        student(name: 'John', id: 'John')
        student(name: 'Rose', id: 'Rose')
    }
    course(name: 'English') {
        teacher(name: 'Emily', id: 'Emily')
        student(refId: 'Mary')
        student(name: 'Alex')
        student(refId: 'Rose')
    }
    course(name: 'Java') {
        teacher(refId: 'Emily')
        student(name: 'mrhaki')
        student(refId: 'John')
        student(refId: 'Mary')
    }
}

assert firstSchool.name == 'First School'
assert firstSchool.courses.size() == 3
assert 'Math' == firstSchool.courses[0].name
assert 'Matt' == firstSchool.courses[0].teacher.name
assert firstSchool.courses[0].students.size() == 3
assert firstSchool.courses.findAll { it.teacher.name == 'Emily' }.name == ['English', 'Java']
assert firstSchool.courses[2].students.find { it.name == 'mrhaki' }.name == 'mrhaki'
assert firstSchool.courses.find { it.name == 'Java' }.students.find { it.name == 'Mary' }.name == 'Mary'