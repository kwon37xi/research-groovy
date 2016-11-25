import groovy.transform.ToString

@ToString
class SimpleEvent {
    @Delegate(excludes = ['after']) Date start
    @Delegate(excludes = ['before']) Date end
    String description
}

def getToday() {
    new Date().clearTime()
}

def getNextWeek() {
    today + 7
}

def event = new SimpleEvent(description: 'Groovy Seminar', start: nextWeek, end: nextWeek + 3)

assert event.before(nextWeek + 1)
assert !event.before(nextWeek - 1)
assert !event.before(today)

assert event.after(today)
assert event.after(nextWeek + 1)
assert !event.after(nextWeek + 4)
