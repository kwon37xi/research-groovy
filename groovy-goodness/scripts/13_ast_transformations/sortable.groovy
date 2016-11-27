import groovy.transform.Sortable
import groovy.transform.ToString

// @Sortable
// Comparable 인터페이스를 구현해준다. comparator 메소드 생성.
// 기본적으로 모든 프라퍼티를 비교대상으로 compareTo 메소드 구현.
// 프라퍼티 순서가 비교 순서.
// includes, excludes 로 조정.
// Comparable을 구현하지 않는 primitive 타입은 사용할 수 없다. 대신 Wrapper 사용가능.
// 더불어 comparatorBy[Property] 라는 static 메소드도 생성해줌.

@Sortable
@ToString
class Course {
    String title
    Date beginDate
    Integer maxAttendees
}

final Course groovy = new Course(title: 'Groovy', beginDate: new Date() + 7, maxAttendees: 40)
final Course groovy2 = new Course(title: 'Groovy', beginDate: new Date() + 2, maxAttendees: 50)
final Course grails = new Course(title: 'Grails', beginDate: new Date() + 1, maxAttendees: 20)

final List<Course> courses = [groovy, groovy2, grails]
assert courses.last().title == 'Grails'

final List<Course> sorted = courses.sort(false) // do not mutate original list

println sorted

assert sorted.first().title == 'Grails'
assert sorted.last().title == 'Groovy'
assert sorted.maxAttendees == [20, 50, 40]


final Comparator byMaxAttendees = Course.comparatorByMaxAttendees()
final List sortedByMaxAttendees = courses.sort(false, byMaxAttendees)

println "SortedByMaxAttendees : ${sortedByMaxAttendees}"
assert sortedByMaxAttendees.maxAttendees == [20, 40, 50]
assert sortedByMaxAttendees[2].beginDate < sortedByMaxAttendees[1].beginDate
assert Course.declaredMethods.name.findAll { it.startsWith('comparatorBy') } == ['comparatorByTitle', 'comparatorByBeginDate', 'comparatorByMaxAttendees']