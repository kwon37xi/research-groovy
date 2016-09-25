// Comparable.compareTo 를 구현한 피연산자간의 비교

class Person implements Comparable<Person> {
    String username
    String email

    @Override
    int compareTo(Person o) {
        this.username <=> o.username
    }
}

assert -1 == ('a' <=> 'b')
assert 0 == (42 <=> 42)
assert 1 == (new Person([username: 'zavaria', email: 'test@email.com']) <=> new Person([username: 'mrhaki', email: 'tester@email.com']))

assert [1, 2, 3, 4] == [4, 2, 1, 3].sort { a, b -> a <=> b} // 정렬 로직으로 사용



