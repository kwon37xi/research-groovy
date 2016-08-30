/*
인스턴스의 metaClass 를 사용하면 해당 인스턴스에만 영향을 끼친다.
 */

// use Person in InjectInstance.groovy

def jack = new Person()
def paul = new Person()


jack.metaClass {
    sing = { ->
        'oh baby baby...'
    }
    dance = { ->
        'start the music'
    }
}

println jack.sing()
println jack.dance()

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