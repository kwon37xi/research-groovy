package dsl

import groovy.transform.ToString


@ToString
class EmailDsl {
    String toText
    String fromText
    String body

    def static make(Closure closure) {
        EmailDsl emailDsl = new EmailDsl()
        // closure 에 대한 모든 메소드 콜은 EmailDsl 클래스 객체로 위임된다.
        closure.delegate = emailDsl
        closure()
        return emailDsl
    }

    def to(String toText) {
        this.toText = toText
    }

    def from(String fromText) {
        this.fromText = fromText
    }

    def body(String bodyText) {
        this.body = bodyText
    }

}
