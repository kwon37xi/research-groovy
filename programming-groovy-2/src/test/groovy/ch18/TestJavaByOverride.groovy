package ch18

class TestJavaCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase {
    void testMyMethod() {
        def testObj = new ExtendedJavaCode()

        def originalPrintStream = System.out
        def printMock = new PrintMock()
        System.out = printMock

        try {
            testObj.myMethod()
        } finally {
            System.out = originalPrintStream
        }

        assertEquals 35, printMock.result
    }
}

class ExtendedJavaCode extends JavaCodeWithHeavierDependencies {
    int someAction() { 25 }
}

class PrintMock extends PrintStream {
    PrintMock() { super(System.out) }

    def result

    void println(int text) { result = text }
}