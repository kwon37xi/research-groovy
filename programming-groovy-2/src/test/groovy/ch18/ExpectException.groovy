package ch18

class ExpectException extends GroovyTestCase {
    void testException() {
        shouldFail ArithmeticException, {
            2 / 0
        }

    }
}
