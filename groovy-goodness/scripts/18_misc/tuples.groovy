// tuple은 순서가 있고, immutable한 요소들의 리스트이다.
// groovy.lang.Tuple
// 생성자로만 요소를 넣어 생성가능하고, 변경 불가.
// Tuple2 : 오직 2개 요소만 있는 튜플. Type있는 요소.

def tuple = new Tuple('one', 1, new Expando(number: 1))

assert tuple.size() == 3

// zero base index
assert tuple.get(0) == 'one'
assert tuple[1] == 1
assert tuple.last().number == 1

// List 를 상속해서 remove, add 등의 메소드가 존재함.
try {
    tuple.add('extra')
    assert false
} catch (ex) {
    assert ex
    println ex.message
}

try {
    tuple.remove('one')
    assert false
} catch (ex) {
    assert ex
    println ex.message
}

def pair = new Tuple2('two', 2)

assert pair.first == 'two'
assert pair.second == 2

def calculate(String key, Integer... values) {
    new Tuple2(key, values.sum())
}

// Tuple2 는 typed object
def (String a, Integer b) = calculate('sum', 1, 2, 3)

assert a == 'sum'
assert b == 6
