import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {
    @Shared
    Sql sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }

    // 각각의 데이터 이터레이션은 별도의 Feature Method와 마찬가지로 서로 격리돼 있다.
    def "maximum of two numbers"(int a, int b, int c) { // 파라미터 생략가능.
        expect:
        Math.max(a, b) == c

        where: "output 부분은 || 로 눈에 잘 띄게 할 수 있다."
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }

    // Unroll 은 Feature Method 를 데이터 Row 별로 분할한다.
    @Unroll
    def "Unrolling maximum of #a and #b is #c"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where: "output 부분은 || 로 눈에 잘 띄게 할 수 있다."
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
    }

    @Unroll
    def "Unrolling maximum of #a and #b is #c with data pipes"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where: "데이터 파이프는 Iterable을 구현하면 됨. 외부 리소스도 상관없다."
        a << [3, 7, 0]
        b << [5, 0, 0]
        c << [5, 7, 0]
    }


    @Unroll
    def "maximum of #a and #b is #c - multi-variable data pipes"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where: "컬렉션의 컬렉션을 리턴하는 외부 리소스로부터 데이터 가져올 때"
//        [a, b, c] << [[3, 5, 5], [7, 0, 7], [0, 0, 0]]
        [a, b, _, c] << sql.rows("select a, b, id, c from maxdata") // 불필요한 데이터에는 _ 사용.
    }

    @Unroll
    def "maximum of #a and #b is #c - data-variable assignment"() {
        expect:
        Math.max(a, b) == c

        where:
        row << sql.rows("select * from maxdata") // 메소드 파라미터를 넣으려면 row 도 파라미터에 지정해야함.
        a = row.a
        b = row.b
        c = row.c
    }

    @Unroll
    def "maximum of #a and #b is #c - combine data-tables, data-pipes and data-variable assignment"() {
        expect:
        Math.max(a, b) == c

        where:
        a | _
        3 | _
        7 | _
        0 | _
        b << [5, 0, 0]
        c = a > b ? a : b
    }

    // 이터레이션이 끝나면 데이터 제공자에 close() 메소드가 존재하면 호출한다.

    // Unroll 메소드 이름
    /*
    GString 과 유사한 구문. 단 메소드에 파라미터를 늘기거나 연산자를 사용할 수 없음.
    def "#person is #person.age years old"() { ... } // property access
    def "#person.name.toUpperCase()"() { ... } // zero-arg method call
    */

}