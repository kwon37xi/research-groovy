package ch06

lst = ['Programming', 'In', 'Groovy']

count = 0
lst.each { count += it.size() }
println count;

println lst.collect { it.size() }.sum() // collect() 는 map() 과 같은 역할

println lst.inject(0) { carryOver, element ->
    carryOver + element.size() // 다음 inject closure의 carryOver가 된다.
} // inject()는 reduce()와 같은 역할.

println lst.join(" ")

lst[0] = ['Be', 'Productive']
println lst
lst = lst.flatten()
println lst
println lst - ['Productive', 'In']

println lst.size()
println lst*.size() // lst 각 항목을 돌며 size() 메소드를 호출하고 그 결과를 다시 list 로 만든다.
println lst.collect { it.size() }
println lst*.size().sum()

// 메소드의 파라미터 인자의 갯수와 동일한 사이즈의 ArrayList 는 메소드 파라미터 목록으로 확장될 수 있다.
def words(a, b, c, d) {
    println "$a $b $c $d"
}

words(*lst) // 파라미터 확장