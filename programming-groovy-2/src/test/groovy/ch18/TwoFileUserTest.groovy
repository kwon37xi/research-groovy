package ch18

import groovy.mock.interceptor.MockFor


class TwoFileUserTest extends GroovyTestCase {
    void testUseFiles() {
        def testObj = new TwoFileUser()
        def testData = 'Multi Files'

        def fileMock = new MockFor(FileWriter)
        fileMock.demand.write() {
            assertEquals testData, it
        }
        fileMock.demand.write() {
            assertEquals testData.size(), it
        }
        fileMock.demand.close(2..2) {} // 2번 호출
        fileMock.use {
            testObj.useFiles(testData)
        }
    }

    // 생성자의 실행을 막지 못하므로 자동 생성된 파일을 지워줘야함.
    void tearDown() {
        new File('output1.txt').delete()
        new File('output2.txt').delete()

    }

    void testSomeWriter() {
        def testObj = new TwoFileUser()

        def fileMock = new MockFor(FileWriter)

        def params = ['one', 'two', 3]
        def index = 0;

        fileMock.demand.write(3..3) {
            it == params[index++]
        }
        fileMock.demand.flush {}
        fileMock.demand.getEncoding { return "whatever" }
        fileMock.demand.write { assertEquals 'whatever', it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.someWriter()
        }
    }
}
