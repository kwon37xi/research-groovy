package ch04

class Handler {
    def f1() {
        println "f1 of Handler called..."
    }

    def f2() {
        println "f2 of Handler called..."
    }
}

class Example {
    def f1() {
        println "f1 of Example called..."
    }

    def f2() {
        println "f2 of Example called..."
    }

    def foo(closure) {
        def handler = new Handler()
//        closure.delegate = handler

//        Closure clone = closure.clone()
//        clone.delegate = handler
//        clone()

        handler.with closure
    }
}

def f1() {
    println "f1 of Script called..."
}

new Example().foo {
    // 이 closure 컨텍스트 안에 Example 객체는 존재하지 않음.

    println "class is " + getClass().name // closure 객체
    println "this is " + this + ", super: " + this.getClass().superclass.name // Script 객체
    println "owner is " + owner + ", super: " + owner.getClass().superclass.name // Script 객체
    println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name // Handler 객체

    f1()
    f2()

}