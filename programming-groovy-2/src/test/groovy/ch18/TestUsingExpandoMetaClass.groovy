package ch18

// 미리 컴파일된 Java Code에 대해서는 작동하지 않음.
class TestUsingExpandoMetaClass extends GroovyTestCase {
    void testMyMethod() {
        def result
        def emc = new ExpandoMetaClass(CodeWithHeavierDependencies, true)
        emc.println = { text -> result = text }
        emc.someAction { -> 25 }
        emc.initialize()

        def testObj = new CodeWithHeavierDependencies()
        testObj.metaClass = emc
        testObj.myMethod()

        assertEquals 35, result

    }

}
