package ch06

lst = [1, 3, 4, 1, 8, 9, 2, 6]
lst.each {
    println it
}
println '-' * 10

lst.reverseEach {
    println it
}
println '-' * 10

lst.eachWithIndex { int entry, int idx ->
    println "${idx} -> ${entry}"
}

println '-' * 10

total = 0
lst.each { total += it }
println "Total is $total"

println '-' * 10

doubled = []
lst.each { doubled << it * 2 }
println doubled

println '-' * 10
println lst.collect { it * 2} // 새로운 ArrayList 로 변환

