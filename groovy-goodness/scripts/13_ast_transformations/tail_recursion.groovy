// @TailRecursive
// closure의 trampoline 처럼 재귀 호출을 Stack이 아닌 순차적 호출로 변경한다..

import groovy.transform.TailRecursive

@TailRecursive
long sizeOfList(list, counter = 0) {
    if (list.size() == 0) {
        counter
    } else {
        sizeOfList(list.tail(), counter + 1)
    }
}

// @TailRecursive 를 제거하면 StackOverFlowError 가 발생한다.
assert sizeOfList(0..10000) == 10001

