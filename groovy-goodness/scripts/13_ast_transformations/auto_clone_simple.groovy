import groovy.transform.AutoClone
import groovy.transform.AutoCloneStyle

// AutoCloneStyle.SIMPLE : 먼저 no-args 생성자를 호출하고 프라퍼티를 복제한다.

@AutoClone(style = AutoCloneStyle.SIMPLE)
class Course {
    String name
    Date date
    Teacher teacher

    static int counter

    Course() {
        counter++
    }
}

@AutoClone(style = AutoCloneStyle.SIMPLE)
class Teacher {
    String name
    static int counter

    Teacher() {
        counter++
    }
}

def mrhaki = new Teacher(name: 'mrhaki')

def course = new Course(
        name: 'Groovy 101',
        date: new Date() + 10,
        teacher: mrhaki)

def otherCourse = course.clone()

assert course.counter == 2
assert course.teacher.counter == 2