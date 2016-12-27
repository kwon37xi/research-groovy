// 문자열을 Map/List로 바꾸기

def original = ['abc', 123, 'Groovy rocks!']

def listAsString = original.toListString()

def list = listAsString[1..-2].split(', ')

assert list.size() == 3
assert list[0] == 'abc'
assert list[1] == '123' // STRING!
assert list[2] == 'Groovy rocks!'

def originalMap = [name: 'mrhaki', age: 42]

def mapAsString = originalMap.toMapString()

def map = mapAsString[1..-2].split(', ').collectEntries { entry ->
            def pair = entry.split(':')
            [(pair.first()): pair.last()]
        }

assert map.size() == 2
assert map.name == 'mrhaki'
assert map.age == '42'