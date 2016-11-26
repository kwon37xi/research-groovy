// 일반 메소드에 대한 캐싱
// @Memoized
import groovy.transform.*

@Field boolean incrementChange = false

@Memoized
int increment(int value) {
    incrementChange = true
    value + 1
}
increment(10)

assert incrementChange

incrementChange = false

// 동일 인자로 호출하면 캐시탐.
increment(10)

// increment()가 캐싱되기 때문에 내부적으로 incrementChange 를 변경하지 못하게 됨
assert !incrementChange

// 다른 인자로 호출하면 캐시 무력화됨
increment(11)
assert incrementChange
