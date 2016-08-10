package ch02

def foo(str) {
//    if (str != null) { str.reverse() }
    str?.reverse()
}

println foo(null)
println foo("evil")

