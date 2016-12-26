import groovy.transform.AutoClone
import groovy.transform.AutoCloneStyle

// AutoCloneStyle.COPY_CONSTRUCTOR
// 동일 타입의 객체를 인자로 받는 protected 생성자를 만들어서 clone() 에서 호출한다.
// 이는 final 필드가 존재해서 생성자에서만 값을 설정할 수 있을 때 사용 가능하다.

@AutoClone(style = AutoCloneStyle.COPY_CONSTRUCTOR)
class Course {
    final String name
    final Date date
    final Teacher teacher

    Course(
            final String name,
            final Date date,
            final Teacher teacher) {
        this.name = name
        this.date = date
        this.teacher = teacher // deep copy는 아닌건가? teacher를 인자로 넣기전 Teacher의 @AutoClone에 따라 clone해서 넣는듯.
    }
}

@AutoClone(style = AutoCloneStyle.COPY_CONSTRUCTOR)
class Teacher {
    final String name

    Teacher(final String name) {
        this.name = name
    }
}

def mrhaki = new Teacher('mrhaki')

def course = new Course(
        'Groovy 101', new Date() + 10, mrhaki
)

def secondCourse = course.clone()
assert secondCourse != course
assert !secondCourse.is(course)
assert secondCourse.teacher != mrhaki
assert !secondCourse.teacher.is(mrhaki)