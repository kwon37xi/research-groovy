package ch18

class CodeWithHeavierDependencies {
    public void myMethod() {
        def value = someAction() + 10
        println(value)
    }

    int someAction() {
        Thread.sleep(5000)
        return Math.random() * 100
    }
}
