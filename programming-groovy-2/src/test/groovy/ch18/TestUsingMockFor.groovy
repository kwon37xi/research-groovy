package ch18

import groovy.mock.interceptor.MockFor


class TestUsingMockFor extends GroovyTestCase {
    void testMethodB() {
        def testObj = new ClassWithDependency()

        def fileMock = new MockFor(FileWriter)
        def text
        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {} // close() 행위 호출에 대한 검증 수행

        fileMock.use {
            testObj.methodB(1)
        }

        assertEquals "The value is 1.", text
    }
}