// @InheritConstructors
// 부모 클래스의 모든 생성자를 자식에게 그대로 만들어줌

import groovy.transform.InheritConstructors

@InheritConstructors
class MyException extends Exception {

}

def e = new MyException()

def e1 = new MyException("exception message")
assert 'exception message' == e1.message

class Person {
    String name

    Person(String name) {
        this.name = name
    }
}

@InheritConstructors
class Child extends Person { }

def child = new Child('Liam')
assert 'Liam' == child.name
