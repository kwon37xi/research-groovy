package ch02

str = 'hello'

if (str) { // null or empty false, otherwise true
    println 'hello'
}

lst0 = null
println lst0 ? 'lis0 true' : 'lst0 false'

lst1 = [1, 2, 3]
println lst1 ? 'lst1 true' : 'lst1 false'

lst2 = []
println lst2 ? 'lst2 true' : 'lst2 false'

// class 에서 asBoolean() 메소드를 구현하여 boolean 으로 자동변환 가능
