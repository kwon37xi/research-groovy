package ch06

list = [1, 3, 4, 1, 8, 9, 2, 6]
println list
println list.getClass().name

println list[0]
println list[list.size() - 1]
println list[-1]
println list[-2]

println list[2..5]
println list[-6..-3]


subList = list.subList(2,5) // 부모를 가지고 있으면서
println subList.dump()
subList[0] = 55
println "After subList[0] = 55 list = $list" // 부모 list 의 값을 바꿔버림.

subList = list[2..5] // 새로운 리스트 인스턴스. 부모리스트와 무관함.
println subList.dump()
subList[0] = 55
println "After subList[0] = 99 list = $list" // 부모 list 의 값을 안바꿈
