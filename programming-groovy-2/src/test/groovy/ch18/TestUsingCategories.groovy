package ch18

// Category는 groovy 코드에만 먹히며, 컴파일된 자바 코드에는 먹히지 않는다.
class TestUsingCategories extends GroovyTestCase {
    void testMyMethod() {
        def testObj = new CodeWithHeavierDependencies()

        use(MockHelper) {
            testObj.myMethod()

            assertEquals 35, MockHelper.result
        }
    }
}

class MockHelper {
    def static result

    def static println(self, text) {
        result = text
    }

    def static someAction(CodeWithHeavierDependencies self) {
        25
    }
}