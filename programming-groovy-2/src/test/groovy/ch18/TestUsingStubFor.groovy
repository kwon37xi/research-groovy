package ch18

import groovy.mock.interceptor.StubFor

// StubFor, MockFor 는 생성자까지 가로채지는 못한다.
class TestUsingStubFor extends GroovyTestCase {
    void testMethodB() {
        def testObj = new ClassWithDependency()

        def fileMock = new StubFor(FileWriter)
        def text
        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.methodB(1)
        }

        assertEquals "The value is 1.", text
    }
}
