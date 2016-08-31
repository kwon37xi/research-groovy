/*
GroovyInterceptable을 구현하면 존재여부와 상관없이 모든 요청이 invokeMethod로 가게된다.
이 경우에는 invokeMethod가 명시적으로 methodMissing을 호출해줘야만 한다.
 */

class PlayPerson3 implements GroovyInterceptable {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

}

