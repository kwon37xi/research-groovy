package ch02

Integer val = 4
val.blah() // compile with no errors, but MissionMethodException occurs
val = "hello" // compile with no errors, but GroovyCastException occurs
println(val)
