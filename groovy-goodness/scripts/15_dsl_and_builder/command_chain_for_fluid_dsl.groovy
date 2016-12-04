import org.codehaus.groovy.groovydoc.GroovyRootDoc

// 메소드 체인할 때 점(.) 없이도 가능하다.
//take 3.apples from basket
//
//take(3.apples).from(basket)
//
//calculate high risk
//calculate(high).risk
//calculate(high).getRisk()
//
//talk to: 'mrhaki' loudly()
//talk(to: 'mrhaki').loudly()

enum Task {
    design, testing, developing
}

enum Client {
    GroovyRoom, OfficeSpace
}

class WorkItem {
    Task task
    Client client
    Integer hours
}

Integer.metaClass.getHour = { -> delegate }
Integer.metaClass.getHours = { -> delegate }

import static Task.*
import static Client.*

workList = []

def worked(Integer hours) {
    ['on': { Task task ->
        ['at': { Client client ->
            workList << new WorkItem(task: task, client: client, hours: hours)
        }]
    }]
}

def developed(Integer hours) {
    ['at': { Client client ->
        workList << new WorkItem(task: developing, client: client, hours: hours)
    }]
}

worked 2.hours on design at GroovyRoom
developed 3.hours at OfficeSpace
developed 1.hour at GroovyRoom
worked 4.hours on testing at GroovyRoom

def total(condition) {
    workList.findAll(condition).sum {
        it.hours
    }
}

assert total({ it.client == GroovyRoom }).hours == 7
assert total({ it.client == OfficeSpace }).hours == 3
assert total({ it.task == developing }).hours == 4
assert total({ it.task == design }).hours == 2
assert total({ it.task == testing }).hours == 4