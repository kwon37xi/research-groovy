class Counter implements Iterable {
    Integer maxValue
    private Integer counter = 0

    @Override
    Iterator iterator() {
//        counter = 0
        [hasNext: { counter <= maxValue }, next: { counter++ }] as Iterator
    }
}

// 아래 함수들은 iterator를 한 번 소진하면 작동 안한다. 이걸 바꾸려면 iterator() 리턴시 counter =0으로 변경해야함.

private getCounter() {
    new Counter(maxValue: 10)
}

assert counter.sum() == 55
assert counter.min() == 0
assert counter.max() == 10
assert counter.count(2) == 1
assert counter.count { it % 2 == 0 } == 6
assert counter.collectMany { [it * 2] } == [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
assert counter.groupBy {
    it % 4 == 0 ? 'fours' : 'noneFours'
} == [fours: [0, 4, 8], noneFours: [1, 2, 3, 5, 6, 7, 9, 10]]
