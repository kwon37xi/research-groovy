package metaobject

/**
 * Meta Object Programming

 * 런타임에 동적으로 클래스와 메소드를 생성한다.
 */
class MetaPropertyAndMethodExample {
    static void main(String[] args) {
        def myStudent = new Student()
        myStudent.Name = "Joe"
        myStudent.ID = 1

        println("Student Name ${myStudent.Name}")
        println("Student ID ${myStudent.ID}")

        println myStudent.AddMarks()

    }

    static class Student implements GroovyInterceptable {
        protected dynamicProps = [:]

        @Override
        Object getProperty(String property) {
            dynamicProps[property]
        }

        @Override
        void setProperty(String property, Object newValue) {
            dynamicProps[property] = newValue
        }

        @Override
        Object invokeMethod(String name, Object args) {
            return "called invokeMethod $name $args"
        }
    }
}
