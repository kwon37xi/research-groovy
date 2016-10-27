// curry()
// parameters bound from left to right
def addNumbers = { x, y -> x + y }
def addOne = addNumbers.curry(1) // x 에 항상 1이 들어감.
assert 5 == addOne(4)

def filterList = { filter, list -> list.findAll(filter) }
def even = { it % 2 == 0 }
def odd = { !even(it) }

def evenFilterList = filterList.curry(even)
def oddFilterList = filterList.curry(odd)
assert [0, 2, 4, 6, 8] == evenFilterList(0..8)
assert [1, 3, 5, 7] == oddFilterList(0..8)

def findText = { filter, handler, text ->
    text.eachLine {
        filter(it) ? handler(it) : null
    }
}

def regexFilter = { pattern, line -> line =~ pattern }
def groovyFilter = regexFilter.curry(/Groovy/)
def printHandler = { println "Found in line : $it" }

def findGroovy = findText.curry(groovyFilter, printHandler)

findGroovy('''Groovy rules!
And Java?
Well... Groovy needs the JVM...
''')

/*
Found in line : Groovy rules!
Found in line : Well... Groovy needs the JVM...
 */