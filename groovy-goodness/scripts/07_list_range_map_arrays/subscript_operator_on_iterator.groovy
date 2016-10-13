// iterator 에 getAt() 구현돼 있음.
// index 값이 앞서 호출한 subscript operator에 의존하고 있음을 잊으면 안됨.

def list = ['Groovy', 'Grails', 'Griffon', 'Gradle']
def iterator = list.iterator()

assert 'Groovy' == iterator[0]
assert 'Gradle' == iterator[-1] // 마지막 값. 여기서 이터레이터가 이미 모두 소진됐음.

assert !iterator[1] // Iterator is exhausted

iterator = list.iterator() // new iterator

def newList = []
(0..<list.size()).each {
    newList << iterator[0] // index 0 is next element
}

assert 'Groovy,Grails,Griffon,Gradle' == newList.join(',')