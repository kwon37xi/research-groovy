package ch10

/**
 * Java 측에서는 GroovyObject.invokeMethod(methodName, args) 를 통해서 동적 메소드 호출이 가능하다.
 */
class DynamicGroovyClass {
    def methodMissing(String name, args) {
        println "You called $name with ${args.join(', ')}."
        args.size()
    }
}
