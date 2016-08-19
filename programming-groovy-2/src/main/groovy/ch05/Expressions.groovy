package ch05


value = 12
println "Hello $value".class.name //GStringImpl
println 'Hello $value'.class.name // String
println(/Hello $value/.class.name) //GStringImpl

println "He paid \$${value} for that."
println "He paid \$$value for that."
println(/He paid $$value for that/)

// lazy evaluation
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text // The cow jumped over the fend

what.replace(0, 5, "moon")
println text // The cow jumped over the moon

def printClassInfo(obj) {
    println "class: ${obj.getClass().name}"
    println "superclass: ${obj.getClass().superclass.name}"
}

val = 125
printClassInfo("The Stock closed at ${value}") // GStringImpl / GString
printClassInfo(/The Stock closed at ${val}/) // GStringImpl / GString
printClassInfo("This is a simple String") // String / Object

