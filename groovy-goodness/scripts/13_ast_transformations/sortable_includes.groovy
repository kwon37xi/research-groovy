import groovy.transform.Sortable
import groovy.transform.ToString

@Sortable(includes = ['title', 'maxAttendees'])
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

final List<Course> sorted = courses.sort(false)

assert sorted.first().title == 'Grails'
assert sorted.last().title == 'Groovy'
assert sorted.maxAttendees == [20, 40, 50]
