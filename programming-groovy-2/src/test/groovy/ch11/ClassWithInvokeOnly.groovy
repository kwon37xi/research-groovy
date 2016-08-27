package ch11


class ClassWithInvokeOnly {
    def existingMethod() {
        'existing method'
    }

    def invokeMethod(String name, args) {
        'invoke called'
    }
}
