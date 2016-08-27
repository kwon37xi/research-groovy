package ch11


class AnInterceptable implements GroovyInterceptable {
    def existingMethod() {}
    def invokeMethod(String name, args) {
        'intercepted'
    }
}
