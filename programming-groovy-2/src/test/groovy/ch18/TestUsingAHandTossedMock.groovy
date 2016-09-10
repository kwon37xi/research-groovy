package ch18

class TestWithExpando extends GroovyTestCase {
    void testMethodA() {
        def testObj = new ClassWithDependency()
        def fileMock = new HandTossedFileMock()
        testObj.methodA(1, fileMock)
        assertEquals "The value is 1.", fileMock.result
    }
}

class HandTossedFileMock {
    def result
    def write(value) { result = value }
}