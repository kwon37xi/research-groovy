/*
인스턴스의 metaClass 를 사용하면 해당 인스턴스에만 영향을 끼친다.
혹은 ExpandoMetaClass 사용하기.
 */

class Person {
    def play() { println 'playing...' }
}

def emc = new ExpandoMetaClass(Person)

emc.sing = { ->
    'oh baby baby...'
}

emc.initialize()

def jack = new Person()
def paul = new Person()


jack.metaClass = emc

println jack.sing()

try {
    paul.sing()
} catch (ex) {
    println ex
}

// 추가한 메소드 없애고 초기화
jack.metaClass = null
try {
    jack.play()
    jack.sing()
} catch (ex) {
    println ex
}