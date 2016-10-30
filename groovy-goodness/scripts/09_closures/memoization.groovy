// cache the result of closure
// memoize()
// memoizeAtMost(), memoizeAtLeast(), memoizeBetween()

def incrementChange = false
def increment = {
    incrementChange = true
    it + 1
}

(0..5).each {
    incrementChange = false
    assert increment(it) == it + 1
    assert incrementChange
}

incrementChange = false
assert increment(1) == 2
assert incrementChange // no cached.

incrementChange = false
def incrementMemoize = increment.memoize()
(0..5).each {
    incrementChange = false
    assert incrementMemoize(it) == it + 1
    assert incrementChange // 최초 한번은 무조건 클로저 내용 실행됨. 그리고 후 캐시
}

incrementChange = false
assert incrementMemoize(2) == 3
assert !incrementChange // cached

// memoizeAtMost()
def memoizeAtMostOnce = increment.memoizeAtMost(1)

(0..5).each {
    incrementChange = false
    assert memoizeAtMostOnce(it) == it + 1
    assert incrementChange
}
incrementChange = false
assert  memoizeAtMostOnce(1) == 2
assert incrementChange // not cached

incrementChange = false
assert  memoizeAtMostOnce(1) == 2
assert !incrementChange // cached