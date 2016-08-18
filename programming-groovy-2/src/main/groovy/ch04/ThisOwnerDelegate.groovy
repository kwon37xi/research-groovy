package ch04

/*
closure 에는 this, owner, delegate 가 존재한다.
보통은 delegate == owner 이다.

this : 클로져가 바인딩 된 클래스. 실행중인 컨텍스트.

클로져안의 변수와 메소드는 this 에 바인딩돼 있는 것을 먼저 찾고 그 다음 owner, 마지막은 delegate에서 찾는다.
 */

def examiningClosure(Closure closure) {
    closure()
}

examiningClosure {
    println "== In First Closure: "
    println "class is " + getClass().name
    println "this is " + this + ", super: " + this.getClass().superclass.name
    println "owner is " + owner + ", super: " + owner.getClass().superclass.name
    println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name

    examiningClosure {
        println "== In Closure within the First Closure: "
        println "class is " + getClass().name
        println "this is " + this + ", super: " + this.getClass().superclass.name
        println "owner is " + owner + ", super: " + owner.getClass().superclass.name
        println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name

    }
}