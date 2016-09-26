// in operator : membership check
// 조건 컨텍스트에서는 in operator는 isCase() 메소드를 호출한다.
// for loop 컨텍스트에서는 iterator() 메소드를 호출한다.

// == Conditional Context
def list = ['Groovy', 'Java']
assert 'Groovy' in list
assert !('Scala' in list)

class MyObject {
    String value
    boolean isCase(ch) {
        value.contains(ch)
    }
}

def myObj = new MyObject(value: 'Groovy')
assert 'oo' in myObj
assert !('oo' in myObj.value) // isCase for String invokes equals

assert 'Groovy' in myObj
assert !('a' in myObj)

// == Iterative Context
def result = ''
for (lang in list) {
    result += lang
}
assert 'GroovyJava' == result

class Counter {
    Integer maxValue
    private Integer counter = 0
    Iterator iterator() {
        [
                hasNext: {counter <= maxValue},
                next: { counter++ }
        ] as Iterator
    }
}

def counter = new Counter(maxValue: 10)
result = ''
for (c in counter) { // iterator() 호출
    result += c
}

assert '012345678910' == result