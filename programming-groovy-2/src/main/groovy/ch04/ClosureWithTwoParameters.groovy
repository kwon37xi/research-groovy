package ch04

def tellFortune(closure) {
    closure new Date("09/20/2012"), "Your day is filled with ceremoney"
}

tellFortune() { date, fortune ->
    println "Fortune for ${date} is '${fortune}'"

}

// typing
tellFortune() { Date date, String fortune ->
    println "Fortune for ${date} is '${fortune}'"
}