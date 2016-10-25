def reversed = [:]
[a: 1, c: 3, b: 2].reverseEach { key, value -> println key; reversed[key] = value**2 }

// map 비교에서 순서는 의미없음.
assert [a: 1, b: 4, c: 9] == reversed
assert [c: 9, b: 4, a: 1] == reversed

println '-' * 20
def tree = [a: 10, c: 30, b: 20] as TreeMap
def reversedMap = [:]
// TreeMap은 key 값을 기준으로 정렬/역정렬 순으로 실행
tree.reverseEach {
    println it.key
    reversedMap[it.key] = it.value * 2
}

// map 비교에서 순서는 의미없음.
assert [c: 60, b: 40, a: 20] == reversedMap
assert [a: 20, c: 60, b: 40] == reversedMap