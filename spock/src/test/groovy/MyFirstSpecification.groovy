import research.spock.ComputerShop
import research.spock.Publisher
import research.spock.Subscriber
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

import java.time.format.DateTimeFormatter

/**
 * <a href="http://spockframework.github.io/spock/docs/1.0/spock_primer.html">Spock Primer</a> 실습
 * Spock은 <code>@CompileStatic</code> 과 조합할 수 없는 것으로 보임.
 * <code>Target method for method call expression hasn't been set</code>라는 에러 발생.
 */
class MyFirstSpecification extends Specification {

    @Subject
    def obj = new Random() // 각각의 테스트 메소드(feature method)간에 공유되지 않고 매번 새로 생성됨
    @Shared
    def formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") // 한 번만 생성되고 모든 테스트 메소드간에 공유됨.

    def stack;

    static final PI = 3.141592654 // 상수에만 static 사용.

    // Fixture methods. optional
    def setup() {
        println "run before every feature method"
        stack = new Stack()
        assert stack.empty
    }

    def cleanup() { println "run after every feature method" }

    // The setupSpec() and cleanupSpec() methods may not reference instance fields.
    def setupSpec() { println "run before the first feature method" }

    def cleanupSpec() { println "run after the last feature method" }

    // A feature method must have at least one explicit (i.e. labelled) block
    def "pushing an element on the stack"() {
        setup: // 항상 맨 앞에. setup: 은 생략 가능. given: 과 동일
        def elem = "push me"

        when:
        stack.push(elem)

        then:
        !stack.empty
        stack.size() == 1
        stack.peek() == elem
    }

    def "maximun of two numbers"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    def "exception test"() {
        when:
        stack.pop()

        then:
//        def e = thrown(EmptyStackException)
        EmptyStackException e = thrown() // 더 명확하다.
        e.cause == null
        e.message == null
    }

    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem") // null key

        then:
        notThrown(NullPointerException)
    }

    def "events are published to all subscribers"() {
        given: // 생략가능
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)
        def publisher = new Publisher()

        publisher.add(subscriber1)
        publisher.add(subscriber2)

        when:
        publisher.send("event")

        then:
        1 * subscriber1.receive("event")
        (1..3) * subscriber2.receive("event")
    }

    def "expect example"() {
//        when:
//        def x = Math.max(1, 2)
//
//        then:
//        x == 2

        expect:
        Math.max(1, 2) == 2
    }

    def "cleanup block"() {
        setup:
        def file = new File("/tmp/spock.txt")

        when:
        file.createNewFile()

        then:
        file.exists()

        cleanup: // cleanup 은 반복되지 않는다. 예외가 발생해도 실행된다. 방어적으로 작성할 것.
        file.delete()

        // 모든 Feature 메소드가 동일한 리소스를 필요로 하면 cleanup() 메소드를
        // 그 외는 가급적 cleanup: 블럭을 사용한다.
    }


    // where: 는 데이터 기반 피쳐 메소드 작성시 사용.
    def "computing the maxmum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
//        a << [5, 3]
//        b << [1, 9]
//        c << [5, 9]
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }

    def "offered PC matches preferred configuration"() {
        setup: "shop 객체를 만든다"
        def shop = new ComputerShop()

        when: "PC를 구매하면"
        def pc = shop.buyPc()

        then: "특정 조건을 만족해야 한다."
//        pc.vendor == "Sunny"
//        pc.clockRate >= 2333
//        pc.ram >= 4096
//        pc.os == "Linux"
        matchesPreferedConfiguration(pc)
    }

    // assert helper method는 각 조건에 assert 문을 사용하고, void 를 return해야 한다.
    // 헬퍼 메소드를 남용하지 말 것. Feature 메소드들 간의 커플링이 높아진다.
    void matchesPreferedConfiguration(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
        assert pc.ram >= 4096
        assert pc.os == "Linux"
    }
}