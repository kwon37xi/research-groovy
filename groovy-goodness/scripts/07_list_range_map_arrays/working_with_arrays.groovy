def strArray = new String[3]
assert strArray instanceof String[]
strArray[0] = 'mrhaki'
strArray.putAt(1, 'Groovy')
strArray[2] = 'Java'

println strArray

assert 'mrhaki' == strArray.getAt(0)
assert 'Groovy' == strArray[1]
assert 'Java' == strArray[-1] // 뒤에서부터
assert ['mrhaki', 'Groovy'] == strArray[0..1]
assert ['mrhaki', 'Java'] == strArray[0, 2]

assert 3 == strArray.length
assert 3 == strArray.size()

assert 42 == [102, 301, 42, 83].min()
assert 301 == [102, 301, 42, 83].max()
assert 'Java' == strArray.min { it.size() }
assert 'mrhaki' == strArray.max { it[0] as char }

// collection method들 사용가능.
strArray.eachWithIndex { String value, int index -> assert value == strArray[index] }
assert ['ikahrm', 'yvoorG', 'avaJ'] == strArray.collect { it.reverse() }
assert 'Groovy' == strArray.find { it =~ /Groovy/ }

assert ['Groovy', 'Java'] == strArray - 'mrhaki' // element 제거

assert ['Java', 'Groovy', 'mrhaki'] == strArray.reverse()
assert ['Groovy', 'Java', 'mrhaki'] == strArray.sort()
assert 1 == strArray.count('mrhaki')

// Convert to ArrayList
def strList = strArray.toList()
assert 'java.util.ArrayList' == strList.class.name

// Convert ArrayList to array object
def otherArray = strList as String[]
assert otherArray instanceof String[]