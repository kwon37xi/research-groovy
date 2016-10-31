// Closure 객체에는 doCall 이라는 메소드가 암시적으로 전재한다.
// 클로져의 인자와 body에 대응한다.
// 클로저를 호출하면 doCall() 이 호출된다.
// 자기 자신을 재호출. 재귀 구성이 간단해진다.

def sizeList = { list, counter = 0 ->
    if (list.size() == 0) {
        counter
    } else {
        doCall(list.tail(), counter + 1)
    }
}

assert 5 == sizeList([1, 2, 3, 4, 5])