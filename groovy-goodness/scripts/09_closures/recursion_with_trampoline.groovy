// recursion with closure trampoline
// recursion 을 작성하면 너무 깊을 경우 stackoverflow가 발생할 수 있다.
// trampoline 으로 이문제를 해결할 수 있다. TrampolineClosure로 클로저를 감싼다.
// trampoline은 recursion을 반복문으로 전환한다.

def sizeList

// list의 사이즈를 구하는듯.
sizeList = { list, counter = 0 ->
    if (list.size() == 0) {
        counter
    } else {
        sizeList.trampoline(list.tail(), counter + 1)
    }
}

sizeList = sizeList.trampoline()
assert sizeList(1..10000) == 10000