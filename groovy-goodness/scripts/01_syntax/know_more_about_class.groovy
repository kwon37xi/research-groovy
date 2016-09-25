// Java Reflection보다 훨씬 편한 기법

interface Simple {}

class Sample implements Simple {
    String info
    String displayInfo() { "info from $Sample.name" } // Sample.name 은 Sample.class.getName()
}

assert 'Sample' == Sample.name
assert 'Sample' == Sample.class.name

def interfaces = Sample.interfaces.name
assert 'Simple' in interfaces
assert 'groovy.lang.GroovyObject' in interfaces

// in 연산자는 isCase() 를 기반으로 작동한다.

def methods = Sample.methods.name
assert 'setInfo' in methods
assert 'getInfo' in methods
assert 'displayInfo' in methods

def s = new Sample()
assert 'info from Sample' == s.displayInfo()