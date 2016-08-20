package ch06

lst = [4, 3, 1, 2, 4, 1, 8, 9, 2, 6]
println lst.find { it % 3 == 0 }
println lst.find { it > 4 }
println lst.findAll { it % 3 == 0 }
println lst.findAll { it > 4 }