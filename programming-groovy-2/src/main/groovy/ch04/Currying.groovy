package ch04

def tellFortunes(closure) {
    Date date = new Date("09/20/2012")

    postFortune = closure.curry(date)
    postFortune "Your day is filled with ceremony"
    postFortune "They're features, not bugs"
}

tellFortunes() { date, fortune ->
    println "Fortune for ${date} is '${fortune}'"
}

// 앞에서부터 파라미터를 커리할 수 있다. 뒤에 나오는 파라미터를 커리할 수는 없다.
// rcurry : 뒤의 파라미터 커리
// ncurry : 중간에 나오는 파라미터 커리
