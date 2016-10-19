// inject - reduce/fold/accumulate 역할.

// 기존 sum 방식
def total = 0
(1..4).each { total += it }
assert 10 == total

def sum = (1..4).inject(0) { result, i -> result + i} // 0은 result 초기값.
assert sum == 10

(1..4).inject(0) { result, i ->
    println "result($result) + current value($i) = ${result + i}"
    result + i
}

class Person {
    String username
    String email
}

def persons = [
        new Person(username: 'mrhaki', email: 'email@host.com'),
        new Person(username: 'hubert', email: 'other@host.com')
]

def map = persons.inject([:]) { result, person ->
    result[person.username] = person.email
    result
}

assert [mrhaki: 'email@host.com', hubert: 'other@host.com'] == map