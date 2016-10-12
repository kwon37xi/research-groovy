// removeAll Closure true로 내려준 엘리먼트 모두 삭제.
// removeElement : remove(int index), remove(Object)의 혼란때문에 무조건 remove(Object)호출.
// removeAt : remove(int index) 호출

def list = ['Groovy', '=', 'gr8!']

list.removeAll {
    it.toLowerCase().startsWith('g')
}

assert list == ['=']

list.removeIf { it instanceof String } // java 8 removeIf
assert list.size() == 0

def values = ['Hello', 'world']

// removeAll(Object[]) 배열내의 객체 모두 삭제.
values.removeAll(['world', 'Hello'] as Object[])
assert values.empty

def items = [1, 2, 3]

// groovy는 모든 int를 Integer로 변환해서 메소드에 넘기기 때문에
// Integer collection 에서 remove 호출시 매우 ambiguous 함.
items.remove(1) // 1 요소를 없애고 싶은것인가? 아니면 index 1의 요소(2)를 없애고 싶은가?
assert items == [1, 3]

items.removeElement(1) // 요소값 1 을 없앰.
assert items == [3]

items.removeAt(0) // 0 번째 요소를 없앰.
assert !items

// retainAll : closure의 조건을 만족시키는 것만 남기고 다 삭제.

list = ['Groovy', 42, 'gr8!', 5.2, new Date()]
list.retainAll { it instanceof String } // String만 남기고 다 삭제
assert list == ['Groovy', 'gr8!']

values = ['Hello', 'world', 'from', 'Groovy']

// Object[] 에 있는 객체만 남기고 나머지 다 삭제.
values.retainAll(['world', 'Hello'] as Object[])
assert values.join(' ') == 'Hello world'