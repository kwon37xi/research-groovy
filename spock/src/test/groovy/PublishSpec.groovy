import research.spock.Publisher
import research.spock.Subscriber
import spock.lang.Specification


/**
 * 모의 객체 생성 필수 사항 : cglib-nodep 2.2 이상, objenesis-1.2 이상.
 * Java 8 의 경우에는 cglib 3.2 이상만 허용됨.
 */
class PublishSpec extends Specification {
    Publisher publisher = new Publisher();

//    def subscriber = Mock(Subscriber);
//    def subscriber2 = Mock(Subscriber);


    // 모의 객체 행위 선언은 Feature Method 에만 속한다(scoped).
    // 따라서 static 메소드에서 호출할 수 없고, 모의 객체를 static이나 @Shared 로 선언할 수도 없다.

    // IDE 자동 완성 지원이 더 유리함.
    Subscriber subscriber = Mock();
    Subscriber subscriber2 = Mock();

    // Mockito와 Spock은 호출이 명시되지 않은 모의 객체 메소드가 호출되어도 기본값을 리턴하고
    // 그냥 넘어간다.
    // JMock과 EasyMock은 모든 메소드 호출을 명시헤야 한다.

    // Spock의 모의객체 메소드 호출은 설정이 없으면 아무런 행위도 하지 않고 기본값을 리턴한다(false, 0, null).

    def setup() {
        publisher.subscribers << subscriber // publisher.getSubscribers().add(subscriber);
        publisher.subscribers << subscriber2
    }

    def "should send messages to all subscribers"() {
        // 모의객체 인터랙션은 보통 then: 블럭에 두지만, 또한 when: 블럭보다 위의 어느 곳에서나 해도 된다.
        // 인터렉션은 :then 블럭에 있는 것이 우선시 된다. 즉 setup:에서 선언한 것을 then: 에서 override 할 수 있다.
        when:
        publisher.send("hello")

        then:
        1 * subscriber.receive("hello") // Mockito - verify(subscriber, times(1)).receive("hello")
        1 * subscriber2.receive("hello")
        // 그 외의 컨디션 검증도 함께 있을 수 있다.
        // publisher.messageCount == 1

        /*
          횟수 조건
            1 * subscriber.receive("hello")      // exactly one call
            0 * subscriber.receive("hello")      // zero calls
            (1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
            (1.._) * subscriber.receive("hello") // at least one call
            (_..3) * subscriber.receive("hello") // at most three calls
            _ * subscriber.receive("hello")      // any number of calls, including zero
                                                 // (rarely needed; see 'Strict Mocking')
         */

        /*
          대상 객체 조건
            1 * subscriber.receive("hello") // a call to 'subscriber'
            1 * _.receive("hello")          // a call to any mock object
         */

        /*
          메소드 조건
            1 * subscriber.receive("hello") // a method named 'receive'
            1 * subscriber./r.*e/("hello")  // a method whose name matches the given regular expression
                                            // (here: method name starts with 'r' and ends in 'e')
            1 * subscriber.status // same as: 1 * subscriber.getStatus()
            1 * subscriber.setStatus("ok") // NOT: 1 * subscriber.status = "ok"
         */

        /*
          인자 조건
            1 * subscriber.receive("hello")     // an argument that is equal to the String "hello"
            1 * subscriber.receive(!"hello")    // an argument that is unequal to the String "hello"
            1 * subscriber.receive()            // the empty argument list (would never match in our example)
            1 * subscriber.receive(_)           // any single argument (including null)
            1 * subscriber.receive(*_)          // any argument list (including the empty argument list)
            1 * subscriber.receive(!null)       // any non-null argument
            1 * subscriber.receive(_ as String) // any non-null argument that is-a String
            1 * subscriber.receive({ it.size() > 3 }) // an argument that satisfies the given predicate
                                                      // (here: message length is greater than 3)
         */

        /*
          Any Mock / Any Method call
            1 * subscriber._(*_)     // any method on subscriber, with any argument list
            1 * subscriber._         // shortcut for and preferred over the above

            1 * _._                  // any method call on any mock object
            1 * _                    // shortcut for and preferred over the above
         */

        /*
          Strict mocking
            when:
            publisher.publish("hello")

            then:
            1 * subscriber.receive("hello") // demand one 'receive' call on 'subscriber'
            _ * auditing._                  // allow any interaction with 'auditing'
            0 * _                           // don't allow any other interaction - 선언된 것을 제외한 다른 모든 인터랙션 금지.
         */

        /*
          큰 변경이 없는 기본 행위 정의
            def subscriber = Mock(Subscriber) {
               1 * receive("hello")
               1 * receive("goodbye")
            }

            or

            Subscriber subscriber = Mock {
                1 * receive("hello")
                1 * receive("goodbye")
            }
         */

        /*
        동일 모의 객체에 대한 인터랙션 그룹핑
            with(subscriber) { // Specification.with()
                1 * receive("hello")
                1 * receive("goodbye")
            }
         */
    }

    // then: 에 있는 모의 객체 행위 선언은 코드 호출시 자동으로 when: 보다 먼저 실행된다.
    // 이때 then: 에서 변수를 선언해 사용하면 해당 변수는 모의 객체가 아니라서 올바로 인식이 안된다.

    def "should send messages to all subscribers - with variable"() {
        def greeting = "hello"
        when:
        publisher.send("hello")

        then:
        // 이 위 치에서 def greeting = "hello" 는 허용안된다. when: 보다 앞에서 모의객체가 사용할 변수 선언할 것.
        1 * subscriber.receive(greeting)
    }

    def "should send messages to all subscribers - with interaction"() {

        when:
        publisher.send("hello")

        then:
        interaction { // 명백하게 모의 객체 행위 선언을 하는 블럭임을 명시. 이 블럭 전체가 when: 블럭보다 앞서 실행됨.
            def greeting = "hello"
            1 * subscriber.receive(greeting)
        }
    }

    // then:은 바로 위의 when: 의 스코프에 들어간다.
    def "scoping interactions"() {
        when:
        publisher.send("message1")

        then:
        1 * subscriber.receive("message1")

        when:
        publisher.send("message2")

        then:
        1 * subscriber.receive("message2")
    }

    // 행위 호출 순서 검증
    // 기본적으로 동일 then: 블럭안의 행위 호출은 순서와 무관하다.
    // 하지만 순서를 보장하고 싶으면 then: 블럭 여러개로 행위 선언을 분할하면 된다.(and: 블럭은 순서 무의미)
    /*
      두 번의 "hello" 호출 뒤에 "goodbye" 호출이 와야함.
        then:
        2 * subscriber.receive("hello")

        then:
        1 * subscriber.receive("goodbye")
     */

    /*
        === Stub ===
        * 호출 횟수에 상관없이 응답 혹은 예외 발생시키기
        * stub 용도로만 사용될때는 setup: 그게 아니면 when:, then: 모두에서 선언가능.

        subscriber.receive(_) >> "ok" // 어떤 인자로든 subscriber.receive()가 호출되면 "ok" 응답.
     */

    def "stub any params"() {
        subscriber.receive(_) >> "ok"

        when:
        def hello = subscriber.receive("hello")
        def world = subscriber.receive("world")

        then:
        hello == "ok"
        world == "ok"
    }

    def "stub returns per params"() {
        subscriber.receive("message1") >> "ok"
        subscriber.receive("message2") >> "fail"

        when:
        def hello = subscriber.receive("message1")
        def world = subscriber.receive("message2")

        then:
        hello == "ok"
        world == "fail"
    }

    def "stub return sequence of values"() {
        // >>> 연산자로 순서대로 리턴할 값 지정
        subscriber.receive(_) >>> ["ok", "error", "error", "ok"]

        when:
        def result1 = subscriber.receive("message1")
        def result2 = subscriber.receive("message2")
        def result3 = subscriber.receive("message3")
        def result4 = subscriber.receive("message4")

        then:
        result1 == "ok"
        result2 == "error"
        result3 == "error"
        result4 == "ok"
    }
}