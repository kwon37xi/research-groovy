/*
GroovyInterceptable을 구현하면 존재여부와 상관없이 모든 요청이 invokeMethod로 가게된다.
이 경우에는 invokeMethod가 명시적으로 methodMissing을 호출해줘야만 한다.
 */

class PlayPerson3 implements GroovyInterceptable {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def invokeMethod(String name, args) {
        System.out.println "intercepting call for $name"

        def method = metaClass.getMetaMethod(name, args)

        if (method) {
            method.invoke(this, args)
        } else {
            // 원본 invokeMethod 호출. 연쇄적으로 methodMissing 호출.
            metaClass.invokeMethod(this, name, args)
        }
    }

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1]}

        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            PlayPerson3 instance = this
            instance.metaClass."$name" = impl // 미래의 요청은 methodMissing을 거치지 않고 메소드에 직접 가게 됨.
            impl(args)
        } else {
            throw new MissingMethodException(PlayPerson3.class, args)
        }
    }
}

jack = new PlayPerson3()
println jack.work()
println jack.playTennis()
println jack.playTennis()
