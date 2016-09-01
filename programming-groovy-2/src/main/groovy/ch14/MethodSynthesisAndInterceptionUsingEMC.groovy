class Person5 {
    def work() { "working..." }
}

Person5.metaClass.invokeMethod = { String name, args ->
    System.out.println "intercepting call for ${name}"

    def method = Person5.metaClass.getMetaMethod(name, args)

    if (method) {
        method.invoke(delegate, args) // 현재 객체에 대해 args 인자를 주어 메소드 호출
    } else {
        Person5.metaClass.invokeMissingMethod(delegate, name, args) // 연쇄적으로 methodMissing 호출
    }
}

Person5.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    System.out.println "methodMissing called for $name"

    def methodInList = plays.find { it == name.split('play')[1] }

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }

        Person5.metaClass."$name" = impl

        impl(args)
    } else {
        throw new MissingMethodException(name, Person5.class, args)
    }
}

jack = new Person5()
println jack.work()
println jack.playTennis()
println jack.playTennis()

try {
    jack.playPolitics()
} catch (ex) {
    println ex
}