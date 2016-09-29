def multiline = '''\
Groovy is closely related to Java,
so it is quite easy to make a
transition.'''

// 클로져에서 각 줄 내용을 받는다.
multiline.eachLine {
    if (it =~ /Groovy/) {
        println it
    }
}

// 각 줄 내용, 줄 번호
multiline.eachLine {line, count ->
    if (count == 0) {
        println "line $count: $line"
    }
}

// 각 플랫폼별 새줄기호로 변경
def platformLinefeeds = multiline.denormalize()


// LF로 변경
def linefeeds = multiline.normalize()

def list = multiline.readLines()
assert list instanceof ArrayList
assert 3 == list.size()
assert 'Groovy is closely related to Java,' == list[0]

def records = """\
mrhaki\tGroovy
hubert\tJava
"""

records.splitEachLine('\t') { items ->
    println items[0] + ' likes ' + items[1]
}
