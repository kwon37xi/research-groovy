import groovy.transform.AutoClone

/*
 @AutoClone

 자동으로 Cloneable 구현

 기본 clone()
   - super.clone() 호출
   - 현재 클래스의 프라퍼티 deep copy
   - 프라퍼티중 clone 안되는 것있으면 예외 발생.

 */

@AutoClone
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
        teacher: mrhaki
)

def secondCourse = course.clone()

assert secondCourse != course
assert !secondCourse.is(course)
assert secondCourse.teacher != course.teacher

secondCourse.name = 'Groovy 101 2nd edition'

assert secondCourse.name == 'Groovy 101 2nd edition'
assert course.name == 'Groovy 101'

