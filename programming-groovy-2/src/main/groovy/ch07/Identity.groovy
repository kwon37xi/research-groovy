package ch07

lst = [1, 2]
lst.add(3)
lst.add(4)
println lst.size()
println lst.contains(2)

println "-- with with"
lst = [1, 2]
lst.with {
    add(3)
    add(4)
    println size()
    println contains(2)
}

lst.with {
    println "this is ${this}"
    println "owner is ${owner},"
    println "delegate is ${delegate}"
}