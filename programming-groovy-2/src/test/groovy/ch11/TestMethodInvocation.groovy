package ch11

/**
 * JUnit 4 의존성이 걸려 있어야 테스트가 올바로 작동한다.
 * JUnit 3 에 의존성을 걸 경우 문제가 발생한다.
 */
class TestMethodInvocation extends GroovyTestCase {
    void testInterceptedMethodCallonPOJO() {
        def val = new Integer(3)

        Integer.metaClass.toString = { -> 'intercepted'}

        println val.toString()
        assertEquals "intercepted", val.toString()
    }

    void testInterceptableCalled() {
        // GroovyInterceptable 상속, invokeMethod 메소드 구현
        def obj = new AnInterceptable()

        // GroovyInterceptable을 상속하면 메소드의 존재 여부와 상관없이 무조건
        // invokeMethod 를 호출한다.
        assertEquals 'intercepted', obj.existingMethod()

        assertEquals 'intercepted', obj.nonExistingMethod()
    }

    void testInterceptedExistingMethodCalled() {
        // 보통 Groovy Object
        AGroovyObject.metaClass.existingMethod2 = {-> 'intercepted'}
        def obj = new AGroovyObject()
        assertEquals 'intercepted', obj.existingMethod2()
    }

    void testUnInterceptedExistingMethodCalled() {
        def obj = new AGroovyObject()
        assertEquals 'existingMethod', obj.existingMethod()
    }

    void testPropertyThatIsClosureCalled() {
        def obj = new AGroovyObject()

        assertEquals 'closure called', obj.closureProp()
    }

    void testMethodMissingCalledOnlyForNonExistent() {
        // invokeMethod, missingMethod만 구현
        def obj = new ClassWithInvokeAndMissingMethod()
        // GroovyInterceptable 을 상속하지 않았기 때문에 이미 존재하는 메소드에 대해서는
        // invokeMethod를 호출하지 않는다.
        assertEquals 'existingMethod', obj.existingMethod()

        // 존재하지 않는 메소드 호출에 대해서만 missingMethod 호출
        assertEquals 'missing called', obj.nonExistingMethod()
    }

    void testInvokeMethodCalledFormOnlyNonExistent() {
        // invokeMethod만 구현
        def obj = new ClassWithInvokeOnly()

        assertEquals 'existing method', obj.existingMethod()
        // missingMethod가 없으면 invokeMethod 호출.
        assertEquals 'invoke called', obj.nonExistingMethod()

    }

    void testMethodFailsOnNonExistent() {
        def obj = new SomeClass()
        // invokeMethod, missingMethod 둘 다 없으면 MissingMethodException 던짐.
        shouldFail (MissingMethodException) {
            obj.nonExistingMethod()
        }
    }

    class SomeClass {
        def existingMethod() {
            'existingMethod'
        }
    }
}