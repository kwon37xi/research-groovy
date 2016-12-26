import groovy.transform.AutoClone

// excludes 프라퍼티로 clone 안 할 프라퍼티 지정

@AutoClone(excludes = ['teacher'])
class Course {
    String name
    Date date
    Teacher teacher
}

@AutoClone
class Teacher {
    String name
}

def mrhaki = new Teacher(name: 'mrhaki')

def course = new Course(
        name: 'Groovy 101',
        date: new Date() + 10,
        teacher: mrhaki)

def secondCourse = course.clone()
assert secondCourse != course
assert !secondCourse.is(course)

// teacher는 shallow copy 되었기 때문에 동일 객체를 공유한다.
assert secondCourse.teacher == mrhaki
assert secondCourse.teacher.is(mrhaki)

secondCourse.teacher.name = 'hubert'

assert secondCourse.teacher.name == 'hubert'
assert course.teacher.name == 'hubert'
