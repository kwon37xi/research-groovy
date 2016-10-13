// Integer.step(), upto(), times()

def result = ''

def createResult = {
    if (!it) {
        result = '0'
    } else {
        result += it
    }
}

for (i = 0; i < 5; i++) {
    createResult(i)
}

assert '01234' == result

0.upto(4, createResult)
assert '01234' == result

5.times(createResult)
assert '01234' == result

0.step 5, 1, createResult
assert '01234' == result

def z = 0
while (z < 5) {
    createResult(z)
    z++
}
assert '01234' == result

def list = [0, 1, 2, 3, 4]
for (int i: list) {
    createResult(i)
}
assert '01234' == result

for (i in list) {
    createResult(i)
}
assert '01234' == result

list.each(createResult)
assert '01234' == result

(0..4).each(createResult)
assert '01234' == result

result = ''
list.eachWithIndex { int listValue, int index ->
    result += "$index$listValue"
}

assert '0011223344' == result