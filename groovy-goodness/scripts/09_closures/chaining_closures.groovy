def convert = { println 'convert'; new Expando(language: it) }
def upper = { println 'upper'; it.toUpperCase() }

def upperConvert = convert << upper // upper가 먼저 실행되고 convert가 실행됨.

def languages = ['Groovy', 'Scala', 'Clojure'].collect(upperConvert)
println languages // [{language=GROOVY}, {language=SCALA}, {language=CLOSURE}]

assert languages[0].language == 'GROOVY'
assert languages[1].language == 'SCALA'
assert languages[2].language == 'CLOJURE'

println '-' * 20
def lastLetter = { println 'lastLetter'; it[-1] }
def firstLetters = ['Groovy', 'Clojure', 'Scala'].collect(upper >> lastLetter) // upper가 먼저 실행되고 lastLetter가 실행됨.

assert firstLetters.join() == 'YEA'