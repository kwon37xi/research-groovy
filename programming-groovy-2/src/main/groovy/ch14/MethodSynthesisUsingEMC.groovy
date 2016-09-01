// metaClass.methodMissing 은 클래스에 직접 선언된 methodMissing보다 우선순위가 높다.
class Person4 {
    def work() { "working..." }
}

Person4.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    System.out.println "methodMissing called for $name"

    def methodInList = plays.find { it == name.split('play')[1] }

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }

        Person4.metaClass."$name" = impl

        impl(args)
    } else {
        throw new MissingMethodException(name, Person4.class, args)
    }
}

jack = new Person4()
println jack.work()
println jack.playTennis()
println jack.playTennis()

try {
    jack.playPolitics()
} catch (ex) {
    println ex
}