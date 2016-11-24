// @Delegate 모든 메소드를 위임하는 메소드 생성.

class SimpleEvent {
    @Delegate Date when
    @Delegate List attendees = []
    int maxAttendees = 0
    String description

    // List.add()만 override
    boolean add(Object value) {
        println attendees.size() + ", " + value
        if (attendees.size() < maxAttendees) {
            return attendees.add(value)
        } else {
            throw new IllegalArgumentException("Maximum of ${maxAttendees} attendees exceeded.")
        }
    }
}

def event = new SimpleEvent(when: new Date() + 7, description: 'Small Groovy Seminar', maxAttendees: 2)
assert 0 == event.size() // List.size()
assert event.after(new Date()) // Date.after()
assert 'Small Groovy Seminar' == event.description
assert 2 == event.maxAttendees

event << 'mrhaki' << 'student1' // List.leftShift()
assert 2 == event.size()
assert 'mrhaki' == event[0]

event -= 'student1' // List.minus()
assert 1 == event.size() // List.size()


// TODO 이거 groovy 버그인듯. event -= 'student1' 이후로는 override한 add 메소드를 안 탐.
// -= 연산을 빼면 정상화된다.
try {
    event << 'student2' << 'three is a crowd.'
    assert false, 'must not be here'
} catch (IllegalArgumentException ex) {
    assert 'Maximum of 2 attendees exceeded.' == ex.message
}
